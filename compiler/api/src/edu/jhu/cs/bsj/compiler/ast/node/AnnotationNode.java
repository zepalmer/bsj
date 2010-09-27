package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * Acts as a base class for annotation nodes.  Subclasses distinguish between the different types of annotation
 * sugar.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnnotationNode extends Node
{
    /**
     * Gets the annotation type.
     * @return The annotation type.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public UnparameterizedTypeNode getAnnotationType() throws ClassCastException;
    
    /**
     * Gets the union object for the annotation type.
     * @return A union object representing The annotation type.
     */
    public NodeUnion<? extends UnparameterizedTypeNode> getUnionForAnnotationType();
    
    /**
     * Changes the annotation type.
     * @param annotationType The annotation type.
     */
    public void setAnnotationType(UnparameterizedTypeNode annotationType);
    
    /**
     * Changes the annotation type.
     * @param annotationType The annotation type.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForAnnotationType(NodeUnion<? extends UnparameterizedTypeNode> annotationType) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationNode deepCopy(BsjNodeFactory factory);
    
}
