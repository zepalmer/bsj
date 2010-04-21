package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

import java.util.List;

import javax.annotation.Generated;
import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaAnnotationInstantiationFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;
import edu.jhu.cs.bsj.compiler.metaprogram.BsjMetaAnnotationMetaprogram;
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MetaAnnotationNodeImpl extends NodeImpl implements MetaAnnotationNode
{
    /** The annotation type. */
    private UnparameterizedTypeNode annotationType;
    
    /** The anchor of a metaprogram attached to this node. */
    private MetaAnnotationMetaprogramAnchorNode metaprogramAnchor;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the annotationType property. */
        ANNOTATION_TYPE,
        /** Attribute for the metaprogramAnchor property. */
        METAPROGRAM_ANCHOR,
    }
    
    /** General constructor. */
    protected MetaAnnotationNodeImpl(
            UnparameterizedTypeNode annotationType,
            MetaAnnotationMetaprogramAnchorNode metaprogramAnchor,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setAnnotationType(annotationType, false);
        this.metaprogramAnchor = metaprogramAnchor;
    }
    
    /**
     * Gets the annotation type.
     * @return The annotation type.
     */
    public UnparameterizedTypeNode getAnnotationType()
    {
        recordAccess(LocalAttribute.ANNOTATION_TYPE, Attribute.AccessType.READ);
        return this.annotationType;
    }
    
    /**
     * Changes the annotation type.
     * @param annotationType The annotation type.
     */
    public void setAnnotationType(UnparameterizedTypeNode annotationType)
    {
            setAnnotationType(annotationType, true);
    }
    
    private void setAnnotationType(UnparameterizedTypeNode annotationType, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.ANNOTATION_TYPE, Attribute.AccessType.WRITE);
        }
        setAsChild(annotationType, false);
        this.annotationType = annotationType;
        setAsChild(annotationType, true);
    }
    
    /**
     * Gets the anchor of a metaprogram attached to this node.
     * @return The anchor of a metaprogram attached to this node.
     */
    public MetaAnnotationMetaprogramAnchorNode getMetaprogramAnchor()
    {
        recordAccess(LocalAttribute.METAPROGRAM_ANCHOR, Attribute.AccessType.READ);
        return this.metaprogramAnchor;
    }
    
    /**
     * Handles the visitation of this node's children for the provided visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        super.receiveToChildren(visitor);
        if (this.annotationType != null)
        {
            this.annotationType.receive(visitor);
        }
        if (this.metaprogramAnchor != null)
        {
            this.metaprogramAnchor.receive(visitor);
        }
    }
    
    /**
     * Handles the visitation of this node's children for the provided typed visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveTypedToChildren(BsjTypedNodeVisitor visitor)
    {
        super.receiveTypedToChildren(visitor);
        if (this.annotationType != null)
        {
            this.annotationType.receiveTyped(visitor);
        }
        if (this.metaprogramAnchor != null)
        {
            this.metaprogramAnchor.receiveTyped(visitor);
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitMetaAnnotationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitMetaAnnotationNodeStop(this);
        visitor.visitStopEnd(this);
    }
    
    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(getAnnotationType());
        list.add(getMetaprogramAnchor());
        return list;
    }
    
    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('[');
        sb.append("annotationType=");
        sb.append(this.getAnnotationType() == null? "null" : this.getAnnotationType().getClass().getSimpleName());
        sb.append(',');
        sb.append("metaprogramAnchor=");
        sb.append(this.getMetaprogramAnchor() == null? "null" : this.getMetaprogramAnchor().getClass().getSimpleName());
        sb.append(',');
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + (this.getStartLocation() != null ? this.getStartLocation().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + (this.getStopLocation() != null ? this.getStopLocation().getClass().getSimpleName() : "null"));
        sb.append(']');
        return sb.toString();
    }
    
    
	/**
	 * The meta-annotation object represented by this AST node.
	 */
	private BsjMetaAnnotation metaAnnotationObject = null;

	/**
	 * {@inheritDoc}
	 */
	public void instantiateMetaAnnotationObject(DiagnosticListener<BsjSourceLocation> listener)
		throws MetaAnnotationInstantiationFailureException
	{
		if (this.metaAnnotationObject == null)
		{
			this.metaAnnotationObject = getManager().instantiateMetaAnnotationObject(this, listener);
			if (this.metaAnnotationObject instanceof BsjMetaAnnotationMetaprogram)
			{
				this.metaprogramAnchor = getManager().instantiateMetaAnnotationMetaprogramAnchor(this);
				setAsChild(this.metaprogramAnchor, true);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public BsjMetaAnnotation getMetaAnnotationObject()
	{
		return this.metaAnnotationObject;
	}
}
