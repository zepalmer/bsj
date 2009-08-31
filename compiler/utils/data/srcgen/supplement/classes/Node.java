/* GEN:importstart */
import java.util.concurrent.atomic.AtomicLong;
/* GEN:importstop */

public abstract class NodeImpl
{
	/* GEN:start */
	/**
	 * The next globally unique UID to assign.
	 */
	private static AtomicLong sUid = new AtomicLong(0);

	/**
	 * The unique ID of this node.
	 */
	private long uid;
	
	/**
	 * The parent for this node.  The object containing the parent is indirected here to allow the setting of the parent
	 * node to be a restricted ability; a third party may have a reference to this object, allowing it to set the parent
	 * property without exposing such functionality as a feature on the node itself.
	 */
	
	
	/**
	 * Assigns this node a UID.
	 */
	{
		this.uid = sUid.getAndIncrement();
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
	
	/* GEN:stop */
}