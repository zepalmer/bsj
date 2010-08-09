package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

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
     */
    public AnnotationValueNode getValue();
    
    /**
     * Changes the value of the "value" element.
     * @param value The value of the "value" element.
     */
    public void setValue(AnnotationValueNode value);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SingleElementAnnotationNode deepCopy(BsjNodeFactory factory);
    
}
