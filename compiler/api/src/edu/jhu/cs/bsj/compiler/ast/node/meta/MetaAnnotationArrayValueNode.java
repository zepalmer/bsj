package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * A value in a meta-annotation representing an array.  This node is distinct from the
 * {@link ArrayInitializerNode} because it allows annotations (by way of
 * {@link MetaAnnotationMetaAnnotationValueNode}) as well as expressions.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaAnnotationArrayValueNode extends Node, MetaAnnotationValueNode, BsjSpecificNode
{
    /**
     * Gets the array values.
     * @return The array values.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public MetaAnnotationValueListNode getValues() throws ClassCastException;
    
    /**
     * Gets the union object for the array values.
     * @return A union object representing The array values.
     */
    public NodeUnion<? extends MetaAnnotationValueListNode> getUnionForValues();
    
    /**
     * Changes the array values.
     * @param values The array values.
     */
    public void setValues(MetaAnnotationValueListNode values);
    
    /**
     * Changes the array values.
     * @param values The array values.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForValues(NodeUnion<? extends MetaAnnotationValueListNode> values) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaAnnotationArrayValueNode deepCopy(BsjNodeFactory factory);
    
}
