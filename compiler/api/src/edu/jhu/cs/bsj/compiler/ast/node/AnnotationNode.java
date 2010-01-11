package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Acts as a base class for annotation nodes.  Subclasses distinguish between the different types of annotation
 * sugar.
 */
public interface AnnotationNode extends Node
{
    /**
     * Gets the annotation type.
     * @return The annotation type.
     */
    public RawTypeNode getAnnotationType();

    /**
     * Changes the annotation type.
     * @param annotationType The annotation type.
     */
    public void setAnnotationType(RawTypeNode annotationType);

}
