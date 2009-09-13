package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing a package declaration, as in
 * <pre>
 *     package <i>packageName</i>;
 * </pre>
 * or
 * <pre>
 *     <i>annotations</i>
 *     package <i>packageName</i>;
 * </pre>
 */
public interface PackageDeclarationNode extends Node
{
    /**
     * Gets the qualified name indicating the package.
     * @return The qualified name indicating the package.
     */
    public QualifiedNameNode getName();

    /**
     * Changes the qualified name indicating the package.
     * @param name The qualified name indicating the package.
     */
    public void setName(QualifiedNameNode name);

    /**
     * Gets the annotations on the package declaration.
     * @return The annotations on the package declaration.
     */
    public ListNode<? extends AnnotationNode> getAnnotations();

    /**
     * Changes the annotations on the package declaration.
     * @param annotations The annotations on the package declaration.
     */
    public void setAnnotations(ListNode<? extends AnnotationNode> annotations);

}
