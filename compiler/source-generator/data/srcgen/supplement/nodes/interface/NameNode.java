public interface NameNode
{
	/* GEN:start */
	// TODO: Protect this method call to prevent it from being abused by misbehaving metaprograms.
	// TODO: Improve error handling; we should be able to log errors on a node based on some vaguely global context
	//       (possibly provided by the node factory?).
	/**
	 * Asserts that this node should fall into the specified category.
	 * @param category The category into which this node should fall.
	 * @throws IllegalStateException If this node cannot fall into that category because it has already been marked with
	 *                               another category.
	 */
	public void assertCategory(NameCategory category);
	
	/**
	 * Retrieves a qualified string representation of this name.  For simple names, this is merely the text of the name;
	 * for qualified names, this is a dot-separated name sequence.
	 * @return The qualified representation of this name.
	 */
	public String getNameString();
	/* GEN:stop */
}