package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;

/**
 * Represents a BSJ compilation unit.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface CompilationUnitNode extends Node
{
    /**
     * Gets the package declaration for this unit.
     * @return The package declaration for this unit.
     */
    public PackageDeclarationNode getPackageDeclaration();

    /**
     * Changes the package declaration for this unit.
     * @param packageDeclaration The package declaration for this unit.
     */
    public void setPackageDeclaration(PackageDeclarationNode packageDeclaration);

    /**
     * Gets the imports used in this unit.
     * @return The imports used in this unit.
     */
    public ImportListNode getImports();

    /**
     * Changes the imports used in this unit.
     * @param imports The imports used in this unit.
     */
    public void setImports(ImportListNode imports);

    /**
     * Gets the global metaprogram imports used in this unit.
     * @return The global metaprogram imports used in this unit.
     */
    public MetaprogramImportListNode getMetaimports();

    /**
     * Changes the global metaprogram imports used in this unit.
     * @param metaimports The global metaprogram imports used in this unit.
     */
    public void setMetaimports(MetaprogramImportListNode metaimports);

    /**
     * Gets the type declarations of this unit.
     * @return The type declarations of this unit.
     */
    public TypeDeclarationListNode getTypeDecls();

    /**
     * Changes the type declarations of this unit.
     * @param typeDecls The type declarations of this unit.
     */
    public void setTypeDecls(TypeDeclarationListNode typeDecls);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public CompilationUnitNode deepCopy(BsjNodeFactory factory);
}
