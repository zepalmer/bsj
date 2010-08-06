package edu.jhu.cs.bsj.compiler.ast.node;

import java.util.Iterator;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.exception.DuplicatePackageMemberException;

/**
 * A node representing a package.  This node has no syntactic equivalent; it is used to represent the
 * object program package hierarchy.  
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface PackageNode extends Node
{
    /**
     * Gets the simple name of this package.
     * @return The simple name of this package.
     */
    public IdentifierNode getName();
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public PackageNode deepCopy(BsjNodeFactory factory);
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

	/**
	 * Starts to load the specified compilation unit in this package. A compilation unit must be loaded before it is
	 * visible in the package hierarchy. Typically, compilation units are loaded by explicit mention when compilation is
	 * started or by dependency inference (such as when a metaprorgam mentions a dependency on a target which is in a
	 * different file or when a type reference is found in an on-demand import). It is possible for metaprograms to
	 * explicitly load compilation units which are not possible to infer, such as when the name of a compilation unit is
	 * mentioned in metaprogram code but no object program code causes a direct reference.
	 * 
	 * @param name The simple name of the compilation unit to load. No file extension should be provided.
	 * @return The loaded compilation unit.
	 */
	public CompilationUnitNode load(String name);

	/**
	 * Performs the load of every compilation unit available in this package.
	 */
	public void loadAll();
}
