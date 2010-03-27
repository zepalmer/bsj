package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;
/**
 * Acts as a base class for meta-annotation nodes.  Subclasses distinguish between the different types of
 * meta-annotation sugar.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaAnnotationNode extends Node
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
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaAnnotationNode deepCopy(BsjNodeFactory factory);
	/**
	 * This method instantiates the meta-annotation object represented by this node.  If this call terminates normally,
	 * the {@link #getMetaAnnotationObject()} method will return a valid object of the appropriate type.
	 */
	public void instantiateMetaAnnotationObject();
	
	/**
	 * Retrieves the meta-annotation object for this node.
	 * @throws IllegalStateException If the annotation object has not yet been instantiated.
	 */
	public BsjMetaAnnotation getMetaAnnotationObject();
}
