package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents a BSJ compilation unit.
 */
public interface CompilationUnitNode extends Node
{
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
     * Gets the annotations on the package declaration of this unit.
     * @return The annotations on the package declaration of this unit.
     */
    public ListNode<? extends AnnotationNode> getPackageAnnotations();

    /**
     * Changes the annotations on the package declaration of this unit.
     * @param packageAnnotations The annotations on the package declaration of this unit.
     */
    public void setPackageAnnotations(ListNode<? extends AnnotationNode> packageAnnotations);

    /**
     * Gets the name of the package for this unit.
     * @return The name of the package for this unit.
     */
    public QualifiedNameNode getPackageName();

    /**
     * Changes the name of the package for this unit.
     * @param packageName The name of the package for this unit.
     */
    public void setPackageName(QualifiedNameNode packageName);

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
