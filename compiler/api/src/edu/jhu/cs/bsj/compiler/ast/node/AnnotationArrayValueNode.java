package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationValueListNode;

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
     * @throws ClassCastException If the value of this property is a special node.
     */
    public AnnotationValueListNode getValues()throws ClassCastException;
    
    /**
     * Gets the union object for the array values.
     * @return A union object representing The array values.
     */
    public NodeUnion<? extends AnnotationValueListNode> getUnionForValues();
    
    /**
     * Changes the array values.
     * @param values The array values.
     */
    public void setValues(AnnotationValueListNode values);
    
    /**
     * Changes the array values.
     * @param values The array values.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForValues(NodeUnion<? extends AnnotationValueListNode> values) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationArrayValueNode deepCopy(BsjNodeFactory factory);
    
}
