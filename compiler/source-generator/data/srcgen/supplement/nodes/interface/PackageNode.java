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

    // TODO: indicate how exceptions are raised in the event of a problem.
    /**
     * Requests that a compilation unit of a specified name be loaded from the indicated package. If this operation is
     * successful, the compilation unit will have been added to the package node by the time the method call terminates.
     * Failure may occur due to parse failures or underlying I/O problems.
     * 
     * @param name The name of the compilation unit to load.
     * @param info The information used for compilation unit loading.
     * @return <code>true</code> if such a compilation unit exists; <code>false</code> if it does not.
     */
    public boolean loadCompilationUnit(String name, CompilationUnitLoadingInfo info);

    // TODO: indicate how exceptions are raised in the event of a problem.
    /**
     * Requests that all available compilation units be loaded from the indicated package. If this operation is
     * successful, the compilation unit will have been added to the package node by the time the method call terminates.
     * Failure may occur due to parse failures or underlying I/O problems.
     * @param info The information used for compilation unit loading.
     */
    public void loadAllCompilationUnits(CompilationUnitLoadingInfo info);
    
    /**
     * Retrieves all compilation units which are contained in this package that meet the provided filter.
     * @param filter The filter to use.
     * @return The resulting mapping of names to compilation units.
     */
    public Map<String, CompilationUnitNode> filterCompilationUnits(NodeFilter<? super CompilationUnitNode> filter);

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
     * @param info The loading info to use to look for the top level type.
     * @return The type's declaration or <code>null</code> if no such declaration exists.
     */
    // TODO: what if the name is ambiguous? (a non-public top-level type with this name also exists, for example)
    // should we report the error?
    public NamedTypeDeclarationNode<?> getTopLevelTypeDeclaration(String name, CompilationUnitLoadingInfo info);

    /**
     * Retrieves the full name of this package node. This method only returns a valid result if the package is attached
     * to the root package.
     * 
     * @return The fully-qualified name of this package node or <code>null</code> if the name could not be determined.
     */
    public String getFullyQualifiedName();

    /* GEN:stop */
}