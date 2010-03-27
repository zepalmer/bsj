/* GEN:headerstart */
/**
 * This interface is implemented by any object which can act as a factory for BSJ nodes. It is strongly advisable to
 * ensure that all nodes in a given AST are produced from the same factory, although the urgency of this restriction is
 * implementation-dependent.
 * 
 * @author Zachary Palmer
 */
/* GEN:headerstop */
public interface BsjNodeFactory
{
	/* GEN:start */
	/**
	 * Retrieves the starting source location used for new nodes.
	 * 
	 * @return The start location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStartSourceLocation();

	/**
	 * Retrieves the ending source location used for new nodes.
	 * 
	 * @return The stop location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStopSourceLocation();

	/**
	 * Changes the starting source location used for new nodes.
	 * 
	 * @param startLocation The new start location to use for new nodes. <code>null</code> is a permissible value and
	 *            indicates that no information is available.
	 */
	public void setStartSourceLocation(BsjSourceLocation startLocation);

	/**
	 * Changes the ending source location used for new nodes.
	 * 
	 * @param stopLocation The new stop location to use for new nodes. <code>null</code> is a permissible value and
	 *            indicates that no information is available.
	 */
	public void setStopSourceLocation(BsjSourceLocation stopLocation);

	/**
	 * Determines whether or not the nodes generated by this factory are marked as "binary" nodes. Nodes are marked as
	 * such to indicate that they originated from precompiled binary files. Binary nodes may not have some information
	 * associated with them; for instance, the bodies of methods on binary nodes are <code>null</code>. This method
	 * typically should not be called except by the BSJ compiler.
	 * 
	 * @return <code>true</code> if the nodes generated by this factory are binary nodes; <code>false</code> otherwise.
	 */
	public boolean getBinary();

	/**
	 * Changes whether or not the nodes generated by this factory are marked as "binary" nodes. This method typically
	 * should not be called except by the BSJ compiler.
	 * 
	 * @param binary <code>true</code> if the nodes generated by this factory are binary nodes; <code>false</code> otherwise.
	 * @see #getBinary()
	 */
	public void setBinary(boolean binary);

	// MANUALLY SPECIFIED MAKE METHODS ///////////////////////////////////////

	/**
	 * Creates a {@link SingleStaticImportNode}. The provided name is interpreted as the full name of the import; that
	 * is, the name "<tt>java.utils.Arrays.asList</tt>" would be used to create an import for that method by splitting
	 * the name between its type and final identifier. The default start and stop location are used.
	 */
	public SingleStaticImportNode makeSingleStaticImportNode(QualifiedNameNode name);

	/**
	 * Creates a {@link SingleStaticImportNode}. The provided name is interpreted as the full name of the import; that
	 * is, the name "<tt>java.utils.Arrays.asList</tt>" would be used to create an import for that method by splitting
	 * the name between its type and final identifier. The specified start and stop locations are used.
	 */
	public SingleStaticImportNode makeSingleStaticImportNode(QualifiedNameNode name, BsjSourceLocation startLocation,
			BsjSourceLocation stopLocation);
	
	/**
	 * Creates a {@link NameNode} based on the specified name string.
	 * @param name The name argument from which to create a node.
	 * @return The name node which was created.
	 * @throws IllegalArgumentException If the provided string was not a valid name.
	 */
	public NameNode parseNameNode(String name);
	/* GEN:stop */
}