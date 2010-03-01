package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class NodeImpl implements Node
{
    /** The location at which this node's text starts (inclusive). */
    private BsjSourceLocation startLocation;

    /** The location at which this node's text stops (exclusive). */
    private BsjSourceLocation stopLocation;

    /** The BSJ node manager for this node. */
    private BsjNodeManager manager;

    /** General constructor. */
    protected NodeImpl(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager)
    {
        super();
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        this.manager = manager;
    }

    /**
     * Gets the location at which this node's text starts (inclusive).
     * @return The location at which this node's text starts (inclusive).
     */
    public BsjSourceLocation getStartLocation()
    {
        return this.startLocation;
    }

    /**
     * Gets the location at which this node's text stops (exclusive).
     * @return The location at which this node's text stops (exclusive).
     */
    public BsjSourceLocation getStopLocation()
    {
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


	/**
	 * The next globally unique UID to assign.
	 */
	private static AtomicLong sUid = new AtomicLong(0);

	/**
	 * The unique ID of this node.
	 */
	private long uid;
	
	/**
	 * Assigns this node a UID.
	 */
	{
		this.uid = sUid.getAndIncrement();
	}
	
	/**
	 * Retrieves the node's manager.
	 * @return This node's manager.
	 */
	protected BsjNodeManager getManager()
	{
		return this.manager;
	}
	
	/**
	 * Causes this node to receive a visitor.  Visitors are received by nodes in a depth-first fashion.  The order of
	 * the children receiving the visitor is dependent upon the type of node; however, a superclass's child nodes are
	 * always visited before the subclass's child nodes.
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
	 * Retrieves the unique ID number of this node.
	 */
	public long getUid()
	{
		return this.uid;
	}
	
	
	/**
	 * Retrieves the parent of this node.  If this node does not have a parent, <code>null</code> is returned.  A node
	 * may be without a parent if it is a {@link CompilationUnitNode} or if it is a code fragment (such as an isolated
	 * expression).
	 * @return This node's parent, or <code>null</code> if this node has no parent.
	 */
	public Node getParent()
	{
		return this.manager.getParent(this);
	}
	
	/**
	 * A convenience method which retrieves the nearest ancestor of this node of the specified type.  Note that a node
	 * is not its own ancestor; thus, providing this node's type as the node class will not retrieve this node.
	 * @param nodeClass The class of ancestor to retrieve.
	 * @return The ancestor in question or <code>null</code> if no such ancestor exists.
	 */
	public <N> N getNearestAncestorOfType(Class<N> nodeClass)
	{
		return getNearestAncestorOfType(nodeClass, null);
	}
	
	/**
	 * A convenience method which retrieves the nearest ancestor of this node of the specified type.  If such an
	 * ancestor exists and the provided list is not <code>null</code>, all of the ancestors between this node and the
	 * returned ancestor are added to the list.
	 * 
	 * Note that a node is not its own ancestor; thus, providing this node's type as the node class will not retrieve
	 * this node.
	 * @param nodeClass The class of ancestor to retrieve.
	 * @param list The list of ancestors or <code>null</code> for no ancestor recording.
	 * @return The ancestor in question or <code>null</code> if no such ancestor exists.  If no such ancestor exists,
	 *         the provided list is unmodified.
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
	 * @return The furthest ancestor of this node (or this node if it has no parent).
	 */
	public Node getFurthestAncestor()
	{
		Node node = this;
		while (node != null)
		{
			node = node.getParent();
		}
		return node;
	}
	
	/**
	 * Retrieves the root package associated with this node.
	 * @return This node's root package (or <code>null</code> if this node is not part of a tree connected to the root
	 * package).
	 */
	public PackageNode getRootPackage()
	{
		Node node = getFurthestAncestor();
		if (node instanceof PackageNode)
		{
			PackageNode packageNode = (PackageNode)node;
			if (packageNode.getName() == null)
			{
				return packageNode;
			}
		}
		return null;
	}
}
