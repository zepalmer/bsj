public interface PackageNode
{
	/* GEN:start */
	/**
	 * Adds a new subpackage to this node. This subpackage cannot already be a member of another package.
	 * 
	 * @param packageNode The package node to add.
	 * @throws DuplicatePackageMemberException If a subpackage with the same name as the provided node already exists.
	 */
	public void addPackage(PackageNode packageNode);

	/**
	 * Retrieves a subpackage of this package.
	 * 
	 * @param name The simple name of the subpackage to retrieve.
	 * @return The subpackage. If it does not exist, a package node is created for this subpackage and returned.
	 */
	public PackageNode getSubpackage(String name);

	/**
	 * Adds a new compilation unit to this node. This compilation unit cannot already be a member of another package.
	 * 
	 * @param compilationUnit The compilation unit to add.
	 * @throws DuplicatePackageMemberException If a compilation unit with the same name as the provided node already
	 *             exists.
	 */
	public void addCompilationUnit(CompilationUnitNode compilationUnit);

	/**
	 * Retrieves a compilation unit in this package.
	 * 
	 * @param name The simple name of the compilation unit to retrieve.
	 * @return The compilation unit. If it does not exist or has not yet been loaded, <code>null</code> is returned.
	 */
	public CompilationUnitNode getCompilationUnit(String name);

	/**
	 * Retrieves an iterator over all loaded compilation units in this package.
	 * 
	 * @return An iterator over all loaded compilation units.
	 */
	public Iterator<CompilationUnitNode> getCompilationUnitIterator();

	/**
	 * Retrieves an iterator over all loaded compilation units in this package and its known subpackages.
	 * 
	 * @return A recursive iterator over all loaded compilation units.
	 */
	public Iterator<CompilationUnitNode> getRecursiveCompilationUnitIterator();

	/**
	 * Retrieves a subpackage of this package by qualified name. This method is provided for convenience and is
	 * equivalent to calling {@link #getSubpackage} compositionally.
	 * 
	 * @param name The qualified name of the subpackage to retrieve. The name components are separated by '.'
	 *            characters.
	 * @return The resulting package node or <code>null</code> if no such node exists.
	 */
	public PackageNode getSubpackageByQualifiedName(String name);

	/**
	 * Retrieves a subpackage of this package by qualified name. This method is provided for convenience and is
	 * equivalent to calling {@link #getSubpackage} compositionally.
	 * 
	 * @param name The qualified name of the subpackage to retrieve.
	 * @return The resulting package node or <code>null</code> if no such node exists.
	 */
	public PackageNode getSubpackageByQualifiedName(NameNode name);

	/**
	 * Retrieves a type declaration for a top level type in this package.
	 * 
	 * @param name The simple name of the top level type.
	 * @return The type's declaration or <code>null</code> if no such declaration exists.
	 */
	// TODO: what if the name is ambiguous? (a non-public top-level type with this name also exists, for example)
	public NamedTypeDeclarationNode<?> getTopLevelTypeDeclaration(String name);

	/**
	 * Retrieves the full name of this package node. This method only returns a valid result if the package is attached
	 * to the root package.
	 * 
	 * @return The fully-qualified name of this package node or <code>null</code> if the name could not be determined.
	 */
	public String getFullyQualifiedName();

	/**
	 * Determines whether or not this package node contains a compilation unit which has the specified simple name. This
	 * may be the case under any of the following three circumstances:
	 * <ul>
	 * <li>When a precompiled binary exists on the object program's classpath which represents the compilation unit.</li>
	 * <li>When a source file exists on the source path which defines the compilation unit.</li>
	 * <li>When a node created by a metaprogram has been explicitly added to this package.</li>
	 * </ul>
	 * This operation conflicts with all write operations.
	 * 
	 * @param name The name of the compilation unit to check.
	 * @return <code>true</code> if the compilation unit exists; <code>false</code> otherwise.
	 */
	public boolean contains(String name);

	/* GEN:stop */
}