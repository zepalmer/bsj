package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * Represents a single element annotation, as in:
 * <pre>@<i>type</i>(<i>value</i>)</pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface SingleElementAnnotationNode extends AnnotationNode
{
    /**
     * Gets the value of the "value" element.
     * @return The value of the "value" element.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public AnnotationValueNode getValue() throws ClassCastException;
    
    /**
     * Gets the union object for the value of the "value" element.
     * @return A union object representing The value of the "value" element.
     */
    public NodeUnion<? extends AnnotationValueNode> getUnionForValue();
    
    /**
     * Changes the value of the "value" element.
     * @param value The value of the "value" element.
     */
    public void setValue(AnnotationValueNode value);
    
    /**
     * Changes the value of the "value" element.
     * @param value The value of the "value" element.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForValue(NodeUnion<? extends AnnotationValueNode> value) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SingleElementAnnotationNode deepCopy(BsjNodeFactory factory);
    
}
