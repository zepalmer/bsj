public interface VariableDeclaratorNode
{
	/* GEN:start */
	/**
	 * Retrieves the type of the variable declared by this variable declarator.  This is usually a copy of the type
	 * on the declaration but may be different if this declarator adds an array type level (such as in
	 * <tt>int x, y[]</tt>).
	 * <p/>
	 * If this node is detached from the primary AST in such a way that it has no ancestor of type
	 * {@link VariableDeclaratorOwnerNode}, <code>null</code> will be returned.
	 * @param factory The factory to use to create new nodes.
	 * @return The effective type of this node.  This will be a fresh node.
	 */
	public TypeNode getEffectiveType(BsjNodeFactory factory);
	/* GEN:stop */
}