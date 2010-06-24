/* GEN:headerstart */
import java.util.concurrent.atomic.AtomicLong;

import edu.jhu.cs.bsj.compiler.impl.ast.exception.*;

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

	/**
	 * Causes this node to receive a visitor. Visitors are received by nodes in a depth-first fashion. The order of the
	 * children receiving the visitor is dependent upon the type of node; however, a superclass's child nodes are always
	 * visited before the subclass's child nodes.
	 * 
	 * @param visitor The visitor which should visit this node.
	 */
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

	/**
	 * Retrieves the unique ID number of this node.
	 */
	public long getUid()
	{
		return this.uid;
	}

	/**
	 * Retrieves the parent of this node. If this node does not have a parent, <code>null</code> is returned. A node may
	 * be without a parent if it is a {@link CompilationUnitNode} or if it is a code fragment (such as an isolated
	 * expression).
	 * 
	 * @return This node's parent, or <code>null</code> if this node has no parent.
	 */
	public Node getParent()
	{
		this.parentAttribute.recordAccess(ReadWriteAttribute.AccessType.READ);
		return this.parent;
	}

	/**
	 * Retrieves the parent node reference object for this node.
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

	/**
	 * Convenience function for marking a node as this node's child or not.
	 * 
	 * @param node The node to use. If <code>null</code>, nothing happens.
	 * @param child <code>true</code> if the node is this node's child; <code>false</code> if it is not.
	 */
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

	/**
	 * A convenience method which retrieves the nearest ancestor of this node of the specified type. Note that a node is
	 * not its own ancestor; thus, providing this node's type as the node class will not retrieve this node.
	 * 
	 * @param nodeClass The class of ancestor to retrieve.
	 * @return The ancestor in question or <code>null</code> if no such ancestor exists.
	 */
	public <N> N getNearestAncestorOfType(Class<N> nodeClass)
	{
		return getNearestAncestorOfType(nodeClass, null);
	}

	/**
	 * A convenience method which retrieves the nearest ancestor of this node of the specified type. If such an ancestor
	 * exists and the provided list is not <code>null</code>, all of the ancestors between this node and the returned
	 * ancestor are added to the list.
	 * 
	 * Note that a node is not its own ancestor; thus, providing this node's type as the node class will not retrieve
	 * this node.
	 * 
	 * @param nodeClass The class of ancestor to retrieve.
	 * @param list The list of ancestors or <code>null</code> for no ancestor recording.
	 * @return The ancestor in question or <code>null</code> if no such ancestor exists. If no such ancestor exists, the
	 *         provided list is unmodified.
	 */
	public <N> N getNearestAncestorOfType(Class<N> nodeClass, List<? super Node> list)
	{
		List<Node> nodeList = new ArrayList<Node>();
		Node node = this.getParent();
		while (node != null)
		{
			if (nodeClass.isInstance(node))
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

	/**
	 * Retrieves the top of the tree in which this node exists.
	 * 
	 * @return The furthest ancestor of this node (or this node if it has no parent).
	 */
	public Node getFurthestAncestor()
	{
		Node node = this;
		while (node.getParent() != null)
		{
			node = node.getParent();
		}
		return node;
	}

	/**
	 * Retrieves the root package associated with this node.
	 * 
	 * @return This node's root package (or <code>null</code> if this node is not part of a tree connected to the root
	 *         package).
	 */
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

	/**
	 * Retrieves the manager for this node.
	 * 
	 * @return The manager for this node.
	 */
	public BsjNodeManager getManager()
	{
		return this.manager;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isBinary()
	{
		return this.binary;
	}
	/* GEN:stop */
}