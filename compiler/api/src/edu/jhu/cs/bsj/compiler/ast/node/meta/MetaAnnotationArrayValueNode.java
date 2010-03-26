package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * A value in a meta-annotation representing an array.  This node is distinct from the
 * {@link ArrayInitializerNode} because it allows annotations (by way of
 * {@link MetaAnnotationMetaAnnotationValueNode}) as well as expressions.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaAnnotationArrayValueNode extends Node, MetaAnnotationValueNode
{
    /**
     * Gets the array values.
     * @return The array values.
     */
    public MetaAnnotationValueListNode getValues();
    
    /**
     * Changes the array values.
     * @param values The array values.
     */
    public void setValues(MetaAnnotationValueListNode values);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaAnnotationArrayValueNode deepCopy(BsjNodeFactory factory);
}
