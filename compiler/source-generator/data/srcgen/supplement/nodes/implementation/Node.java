/* GEN:headerstart */
import java.util.Collections;
import java.util.concurrent.atomic.AtomicLong;

import edu.jhu.cs.bsj.compiler.impl.ast.exception.*;

import edu.jhu.cs.bsj.compiler.impl.tool.serializer.BsjSourceSerializerImpl;

import edu.jhu.cs.bsj.compiler.impl.utils.MultiMap;
/* GEN:headerstop */

public abstract class NodeImpl
{
	/* GEN:start */
	/**
	 * The parent attribute for this node.
	 */
	private ReadWriteAttribute parentAttribute = new ReadWriteAttribute(this);

	/**
	 * The next globally unique UID to assign.
	 */
	private static AtomicLong sUid = new AtomicLong(0);

	/**
	 * The unique ID of this node.
	 */
	private long uid;

	/**
	 * The parent for this node.
	 */
	private Node parent = null;
	/**
	 * A variable indicating whether or not the <code>parent</code> variable has ever been set.
	 */
	private boolean parentSet = false;

	/**
	 * Assigns this node a UID.
	 */
	{
		this.uid = sUid.getAndIncrement();
	}

	public void receive(BsjNodeVisitor visitor)
	{
		visitor.visitStart(this);
		receiveToChildren(visitor);
		visitor.visitStop(this);
	}

	/**
	 * Used to obtain an iterator of additional children of this node that visitors should visit. The default
	 * implementation specifies no additional children.
	 * 
	 * @return An iterator of children that visitors to this node should visit. If <code>null</code>, no additional
	 *         children are used.
	 */
	protected Iterator<? extends Node> getHiddenVisitorChildren()
	{
		return new EmptyIterator<Node>();
	}

	public long getUid()
	{
		return this.uid;
	}

	public Node getParent()
	{
		this.parentAttribute.recordAccess(ReadWriteAttribute.AccessType.READ);
		return this.parent;
	}

	/**
	 * Changes the parent node reference object for this node.
	 * 
	 * @param node The parent node for this node.
	 */
	public void setParent(Node node)
	{
		if (this.parent != null && node != null)
		{
			throw new MultipleParentNodeExceptionImpl(node, this);
		}
		// The first write to the parent property of a node is not recorded for the same reason that writes when a node
		// is created are not recorded. This allows list predicate filters to move up a pristine subtree without
		// causing a conflict.
		if (this.parentSet)
		{
			this.parentAttribute.recordAccess(ReadWriteAttribute.AccessType.WRITE);
		}
		this.parentSet = true;
		this.parent = node;
	}

	protected void setAsChild(Node node, boolean child)
	{
		if (node instanceof NodeImpl)
		{
			((NodeImpl) node).setParent(child ? this : null);
		} else if (node != null)
		{
			// TODO: throw an exception indicating a heterogeneous tree?
		}
	}

	public <N> N getNearestAncestorOfType(Class<N> nodeClass)
	{
		return getNearestAncestorOfType(nodeClass, null);
	}

	public <N> N getNearestAncestorOfType(Class<N> nodeClass, List<? super Node> list)
	{
		return this.getNearestAncestorOfTypes(Collections.<Class<? extends N>>singletonList(nodeClass), list);
	}
	
	public <N> N getNearestAncestorOfTypes(Collection<Class<? extends N>> nodeClasses)
	{
		return getNearestAncestorOfTypes(nodeClasses, null);
	}
	
	public <N> N getNearestAncestorOfTypes(Collection<Class<? extends N>> nodeClasses, List<? super Node> list)
	{
		List<Node> nodeList = new ArrayList<Node>();
		Node node = this.getParent();
		while (node != null)
		{
			Class<? extends N> nodeClass = null;
			for (Class<? extends N> candidateClass : nodeClasses)
			{
				if (candidateClass.isInstance(node))
				{
					nodeClass = candidateClass;
					break;
				}
			}
			if (nodeClass != null)
			{
				if (list != null)
				{
					list.addAll(nodeList);
				}
				return nodeClass.cast(node);
			}
			nodeList.add(node);
			node = node.getParent();
		}
		return null;
	}

	public Node getFurthestAncestor()
	{
		Node node = this;
		while (node.getParent() != null)
		{
			node = node.getParent();
		}
		return node;
	}

	public PackageNode getRootPackage()
	{
		Node node = getFurthestAncestor();
		if (node instanceof PackageNode)
		{
			PackageNode packageNode = (PackageNode) node;
			if (packageNode.getName() == null)
			{
				return packageNode;
			}
		}
		return null;
	}

	public BsjNodeManager getManager()
	{
		return this.manager;
	}

	public boolean isBinary()
	{
		return this.binary;
	}
	
	public String toSourceCode()
	{
		return this.executeOperation(new BsjSourceSerializerImpl(), null);
	}

	public Collection<? extends Node> getDeclarationsInScope(NameNode name)
	{
		return this.getManager().getDeclarationsInScope(this, name);
	}
	
	public Collection<? extends TypeNameBindingNode> getTypeDeclarationsInScope(String name)
	{
		return this.getManager().getTypeDeclarationsInScope(this, name);
	}
	
	public Collection<? extends InvokableNameBindingNode> getMethodDeclarationsInScope(String name)
	{
		return this.getManager().getMethodDeclarationsInScope(this, name);
	}
	
	public Collection<? extends VariableNameBindingNode> getVariableDeclarationsInScope(String name)
	{
		return this.getManager().getVariableDeclarationsInScope(this, name);
	}

	/* GEN:stop */
}