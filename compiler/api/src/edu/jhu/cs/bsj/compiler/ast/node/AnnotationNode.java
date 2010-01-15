package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * Acts as a base class for annotation nodes.  Subclasses distinguish between the different types of annotation
 * sugar.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
public interface AnnotationNode extends Node
{
    /**
     * Gets the annotation type.
     * @return The annotation type.
     */
    public UnparameterizedTypeNode getAnnotationType();

    /**
     * Changes the annotation type.
     * @param annotationType The annotation type.
     */
    public void setAnnotationType(UnparameterizedTypeNode annotationType);

}
