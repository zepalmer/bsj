package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.concurrent.atomic.AtomicLong;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

public abstract class NodeImpl implements Node
{
    /** General constructor. */
    protected NodeImpl()
    {
        super();
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
	 * Handles the visitation of this node's children for the provided visitor.  Each subclass should override this
	 * method, having the subclass implementation call this method first and then visit its subclass-specific children.
	 * 
	 * @param visitor The visitor which should visit this node.
	 */
	protected abstract void receiveToChildren(BsjNodeVisitor visitor);
	
	/**
	 * Retrieves the unique ID number of this node.
	 */
	public long getUid()
	{
		return this.uid;
	}
	
	/**
	 * The unique ID of this node.
	 */
	private long uid;
	
	/**
	 * The next globally unique UID to assign.
	 */
	private static AtomicLong sUid = new AtomicLong(0);

	
	/**
	 * Assigns this node a UID.
	 */
	{
		this.uid = sUid.getAndIncrement();
	}
}
