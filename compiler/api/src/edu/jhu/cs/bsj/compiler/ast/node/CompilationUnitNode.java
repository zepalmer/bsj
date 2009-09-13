package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents a BSJ compilation unit.
 */
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
    public ListNode<? extends ImportNode> getImports();

    /**
     * Changes the imports used in this unit.
     * @param imports The imports used in this unit.
     */
    public void setImports(ListNode<? extends ImportNode> imports);

    /**
     * Gets the type declarations of this unit.
     * @return The type declarations of this unit.
     */
    public ListNode<? extends TypeDeclarationNode> getTypeDecls();

    /**
     * Changes the type declarations of this unit.
     * @param typeDecls The type declarations of this unit.
     */
    public void setTypeDecls(ListNode<? extends TypeDeclarationNode> typeDecls);

}
