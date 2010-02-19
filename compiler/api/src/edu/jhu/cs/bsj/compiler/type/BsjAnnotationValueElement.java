package edu.jhu.cs.bsj.compiler.type;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents an annotation element-value pair.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjAnnotationValueElement
{
    /**
     * Gets the name of the annotation parameter filled by this element.
     * @return The name of the annotation parameter filled by this element.
     */
    public String getName();

    /**
     * Gets the value of the annotation parameter.
     * @return The value of the annotation parameter.
     */
    public BsjAnnotationValue getValue();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjAnnotationValueElement deepCopy(BsjNodeFactory factory);
}
