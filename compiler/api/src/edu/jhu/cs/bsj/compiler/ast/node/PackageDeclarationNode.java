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
     * Gets the name of the package.
     * @return The name of the package.
     */
    public NameNode getName();

    /**
     * Changes the name of the package.
     * @param name The name of the package.
     */
    public void setName(NameNode name);

    /**
     * Gets the annotations on the package declaration.
     * @return The annotations on the package declaration.
     */
    public ListNode<AnnotationNode> getAnnotations();

    /**
     * Changes the annotations on the package declaration.
     * @param annotations The annotations on the package declaration.
     */
    public void setAnnotations(ListNode<AnnotationNode> annotations);

}
