package edu.jhu.cs.bsj.compiler.type;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents an annotation value which is itself another annotation.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjAnnotationAnnotationReferenceValue extends BsjAnnotationValue
{
    /**
     * Gets the annotation reference used in this value.
     * @return The annotation reference used in this value.
     */
    public BsjAnnotationReference getReference();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjAnnotationAnnotationReferenceValue deepCopy(BsjNodeFactory factory);
}
