package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.InvokableNameBindingNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNameBindingNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNameBindingNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.StringName;
import edu.jhu.cs.bsj.compiler.impl.ast.exception.MultipleParentNodeExceptionImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.serializer.BsjSourceSerializerImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.EmptyIterator;
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class NodeImpl implements Node
{
    /** The location at which this node's text starts (inclusive). */
    private BsjSourceLocation startLocation;
    
    /** The location at which this node's text stops (exclusive). */
    private BsjSourceLocation stopLocation;
    
    /** The BSJ node manager for this node. */
    private BsjNodeManager manager;
    
    /** Whether or not this node originated in a binary file. */
    private boolean binary;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(NodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the startLocation property. */
        START_LOCATION,
        /** Attribute identifier for the stopLocation property. */
        STOP_LOCATION,
        /** Attribute identifier for the manager property. */
        MANAGER,
        /** Attribute identifier for the binary property. */
        BINARY,
    }
    
    /** General constructor. */
    protected NodeImpl(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super();
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        this.manager = manager;
        this.binary = binary;
    }
    
    /**
     * Gets the location at which this node's text starts (inclusive).
     * @return The location at which this node's text starts (inclusive).
     */
    public BsjSourceLocation getStartLocation()
    {
        getAttribute(LocalAttribute.START_LOCATION).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.startLocation;
    }
    
    /**
     * Gets the location at which this node's text stops (exclusive).
     * @return The location at which this node's text stops (exclusive).
     */
    public BsjSourceLocation getStopLocation()
    {
        getAttribute(LocalAttribute.STOP_LOCATION).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.stopLocation;
    }
    
    /**
     * Handles the visitation of this node's children for the provided visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receive(visitor);
            }
        }
    }
    
    /**
     * Handles the visitation of this node's children for the provided typed visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    protected void receiveTypedToChildren(BsjTypedNodeVisitor visitor)
    {
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receiveTyped(visitor);
            }
        }
    }
    
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitStopEnd(this);
    }
    
    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    public List<Object> getChildObjects()
    {
        List<Object> list = new ArrayList<Object>();
        list.add(getStartLocation().toString() + " - " + getStopLocation().toString());
        return list;
    }
    
    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('[');
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + (this.getStartLocation() != null ? this.getStartLocation().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + (this.getStopLocation() != null ? this.getStopLocation().getClass().getSimpleName() : "null"));
        sb.append(']');
        return sb.toString();
    }
    
    
    
    private static final StringName PARENT_NAME = new StringName("parent");
    
    /**
     * The parent attribute for this node.
     */
    private ReadWriteAttribute parentAttribute = new ReadWriteAttribute(this, PARENT_NAME);

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

	public boolean equals(Object object)
	{
		if (object instanceof NodeImpl)
		{
			NodeImpl other = (NodeImpl)object;
			return (this.uid == other.uid);
		} else
		{
			return false;
		}
	}
	
	public int hashCode()
	{
		return (int)this.uid;
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

}
