package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A value in an annotation representing an array.  This node is distinct from the {@link ArrayInitializerNode}
 * because it allows annotations (by way of {@link AnnotationAnnotationValueNode}) as well as expressions.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnnotationArrayValueNode extends Node, AnnotationValueNode
{
    /**
     * Gets the array values.
     * @return The array values.
     */
    public ListNode<AnnotationValueNode> getValues();

    /**
     * Changes the array values.
     * @param values The array values.
     */
    public void setValues(ListNode<AnnotationValueNode> values);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationArrayValueNode deepCopy(BsjNodeFactory factory);
}
