package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A value in an annotation representing an array.  This node is distinct from the {@link ArrayInitializerNode}
 * because it allows annotations (by way of {@link AnnotationAnnotationValueNode}) as well as expressions.
 */
public interface AnnotationArrayValueNode extends AnnotationValueNode
{
    /**
     * Gets the array values.
     * @return The array values.
     */
    public ListNode<? extends AnnotationValueNode> getValues();

    /**
     * Changes the array values.
     * @param values The array values.
     */
    public void setValues(ListNode<? extends AnnotationValueNode> values);

}
