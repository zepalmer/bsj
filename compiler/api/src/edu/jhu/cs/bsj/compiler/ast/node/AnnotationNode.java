package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents the usage of an annotation, as in:
 * <pre>@<i>type</i>(<i>arg...</i>)</pre>
 */
public interface AnnotationNode extends ExpressionNode
{
    /**
     * Gets the annotation type.
     * @return The annotation type.
     */
    public DeclaredTypeNode getAnnotationType();

    /**
     * Changes the annotation type.
     * @param annotationType The annotation type.
     */
    public void setAnnotationType(DeclaredTypeNode annotationType);

    /**
     * Gets the arguments.
     * @return The arguments.
     */
    public ListNode<? extends ExpressionNode> getArguments();

    /**
     * Changes the arguments.
     * @param arguments The arguments.
     */
    public void setArguments(ListNode<? extends ExpressionNode> arguments);

}
