/* GEN:headerstart */
import java.util.concurrent.atomic.AtomicLong;
/* GEN:headerstop */

import edu.jhu.cs.bsj.compiler.impl.utils.MultiMap;
import edu.jhu.cs.bsj.compiler.impl.Attribute;

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
	 * The parent for this node.
	 */
	private Node parent = null;
	
	/**
	 * Assigns this node a UID.
	 */
	{
		this.uid = sUid.getAndIncrement();
	}
	
	/**
	 * A data structure containing information about attribute access.
	 */
	static class AccessRecord extends Pair<Attribute.AccessType, Integer>
	{
		public AccessRecord(Attribute.AccessType accessType, Integer id)
		{
			super(accessType, id);
		}
		
		/**
		 * Gets the type of access from this access record.
		 */
		public Attribute.AccessType getAccessType()
		{
			return this.getFirst();
		}
		 
		/**
		 * Gets the metaprogram ID from this access record.
		 */
		public Integer getMetaprogramID()
		{
			return this.getSecond();
		}
	}
	
    /** The current set of access record for this node's attributes. */
    private MultiMap<Attribute, AccessRecord> accessRecordMap = new HashMultiMap<Attribute, AccessRecord>();
    
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
		return this.parent;
	}
	
	/**
	 * Retrieves the parent node reference object for this node.
	 * @param node The parent node for this node.
	 */
	public void setParent(Node node)
	{
		// TODO: some way of validating the argument (so a rogue metaprogrammer doesn't make the tree inconsistent)
		// currently, we're using instanceof in every Node subclass setter - this is not cool
		// Perhaps a central registry based on node ID number?  That way the relationship isn't duplicated; the
		// getParent method can just perform a registry lookup
		this.parent = node;
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
	
	/**
	 * Retrieves the manager for this node.
	 * @return The manager for this node.
	 */
	protected BsjNodeManager getManager()
	{
		return this.manager;
	}
	
	/**
	 * Records an attribute access for this node.  If this access is in conflict with other accesses which have already
	 * occurred on this node, an approprite exception is thrown.
	 * @param attribute The attribute that was accessed.
	 * @param accessType The type of access that was involved.
	 * @throws MetaprogramConflictException If a conflict exists between this access and one which has already occurred.
	 */
	protected void recordAccess(Attribute attribute, Attribute.AccessType accessType)
			throws MetaprogramConflictException
	{
		if (this.manager.getCurrentMetaprogramId() == null)
		{
			return;
		}
		
		Set<AccessRecord> previousAccesses = this.accessRecordMap.getAll(attribute);
		for (AccessRecord record : previousAccesses)
		{
			Attribute.AccessType recordAccessType = record.getAccessType();
			if (accessType.canConflict(recordAccessType))
			{
				this.manager.assertCooperation(record.getMetaprogramID());
			}
		}
		
		this.accessRecordMap.put(attribute, new AccessRecord(accessType, this.manager.getCurrentMetaprogramId()));
	}
	/* GEN:stop */
}