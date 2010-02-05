public interface Node
{
	/* GEN:start */
	/**
	 * Causes this node to receive a visitor.  Visitors are received by nodes in a depth-first fashion.  The order of
	 * the children receiving the visitor is dependent upon the type of node; however, a superclass's child nodes are
	 * always visited before the subclass's child nodes.
	 * 
	 * @param visitor The visitor which should visit this node.
	 */
	public void receive(BsjNodeVisitor visitor);
	
	/**
	 * Causes this node to receive a type-specific visitor.  Visitors are received by nodes in a depth-first fashion.
	 * The order of the children receiving the visitor is dependent upon the type of node; however, a superclass's child
	 * nodes are always visited before the subclass's child nodes.  For more information on exactly what calls are made,
	 * please see {@link BsjTypedNodeVisitor}.
	 * 
	 * @param visitor The visitor which should visit this node.
	 */
	public void receiveTyped(BsjTypedNodeVisitor visitor);
	
	/**
	 * Retrieves the unique ID number of this node.
	 * @return The unique ID number of this node.
	 */
	public long getUid();
	
	/**
	 * Retrieves the parent of this node.  If this node does not have a parent, <code>null</code> is returned.  A node
	 * may be without a parent if it is a {@link CompilationUnitNode} or if it is a code fragment (such as an isolated
	 * expression).
	 * @return This node's parent, or <code>null</code> if this node has no parent.
	 */
	public Node getParent();
	
	/**
	 * Retrieves the children of this node.  The children are not in any guaranteed order.  This method is intended to
	 * be used primarily for debugging purposes.  It should not be called routinely at runtime for performance reasons.
	 * <p/>
	 * Note that the children of this node may not be nodes themselves (such as when a node property is of a primitive
	 * type).
	 * 
	 * @return A list of this node's children.  The list in question is for reference purposes; it is mutable and
	 *         changing it has no effect on this node.
	 */
	public List<Object> getChildObjects();

	/**
	 * Executes an operation on this node.
	 * @param operation The operation to perform.
	 * @param p The parameter to pass to the operation.
	 * @return The result of the operation.
	 */
	public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p);
	
	/**
	 * Replaces one child node value with another.  This convenience method is provided to allow children to remove
	 * themselves from their parents when necessary, replacing themselves with another node.  It is more efficient to
	 * call the appropriate setter directly (such as <tt>getParent().setPackageDeclaration(...)</tt>), but this method
	 * is convenient in cases in which the caller does not know where in its parent it resides (which is especially
	 * the case with lists).
	 * @param before The node which is to be replaced.  <code>null</code> is not a legal value.
	 * @param after The node with which it is to be replaced.
	 * @return <code>true</code> if the replacement was successful; <code>false</code> if the specified <tt>before</tt>
	 * node was not found.
	 * @throws IllegalArgumentException If <tt>before</tt> is <code>null</code>.
	 */
	public <N extends Node> boolean replace(N before, N after);
	/* GEN:stop */
}