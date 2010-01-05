package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents the usage of an annotation, as in:
 * <pre>@<i>type</i>(<i>value</i>)</pre>
 * or
 * <pre>@<i>type</i>(<i>key</i>=<i>value</i>,...)</pre>
 * If the annotation has only a single (default) value, the arguments list will contain a single
 * <tt>AnnotationValueNode</tt> with a <tt>null</tt> identifier.
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
    public ListNode<? extends AnnotationValueNode> getArguments();

    /**
     * Changes the arguments.
     * @param arguments The arguments.
     */
    public void setArguments(ListNode<? extends AnnotationValueNode> arguments);

}
