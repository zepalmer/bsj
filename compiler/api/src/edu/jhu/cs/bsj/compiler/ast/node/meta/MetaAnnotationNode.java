package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;
import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaAnnotationInstantiationFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;
/**
 * Acts as a base class for meta-annotation nodes.  Subclasses distinguish between the different types of
 * meta-annotation sugar.  The <tt>metaprogramAnchor</tt> field is used when the meta-annotation for this
 * node represents a metaprogram; otherwise, it is <tt>null</tt>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaAnnotationNode extends Node, BsjSpecificNode
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
     * Gets the anchor of a metaprogram attached to this node.
     * @return The anchor of a metaprogram attached to this node.
     */
    public MetaAnnotationMetaprogramAnchorNode getMetaprogramAnchor();
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaAnnotationNode deepCopy(BsjNodeFactory factory);
    
	/**
	 * This method instantiates the meta-annotation object represented by this node.  If this call terminates normally,
	 * the {@link #getMetaAnnotationObject()} method will return a valid object of the appropriate type.  If this
	 * node already has an associated meta-annotation object, a call to this method will do nothing and terminate
	 * normally.  This method is typically used by the BSJ compiler to instantiate meta-annotation objects; normal
	 * metaprogram execution has no reason to invoke this method.
	 * @param listener The listener to which diagnostics should be reported.
	 * @throws MetaAnnotationInstantiationFailureException If instantiation of the meta-annotation object fails.
	 */
	public void instantiateMetaAnnotationObject(DiagnosticListener<BsjSourceLocation> listener)
		throws MetaAnnotationInstantiationFailureException;
	
	/**
	 * Retrieves the meta-annotation object for this node.
	 * @throws IllegalStateException If the annotation object has not yet been instantiated.
	 */
	public BsjMetaAnnotation getMetaAnnotationObject();
}
