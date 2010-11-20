package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;
import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaAnnotationInstantiationFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;
import edu.jhu.cs.bsj.compiler.metaprogram.BsjMetaAnnotationMetaprogram;
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MetaAnnotationNodeImpl extends NodeImpl implements MetaAnnotationNode
{
    /** The annotation type. */
    private NodeUnion<? extends UnparameterizedTypeNode> annotationType;
    
    /** The anchor of a metaprogram attached to this node. */
    private MetaAnnotationMetaprogramAnchorNode metaprogramAnchor;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(MetaAnnotationNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the annotationType property. */
        ANNOTATION_TYPE,
        /** Attribute identifier for the metaprogramAnchor property. */
        METAPROGRAM_ANCHOR,
    }
    
    /** General constructor. */
    protected MetaAnnotationNodeImpl(
            NodeUnion<? extends UnparameterizedTypeNode> annotationType,
            MetaAnnotationMetaprogramAnchorNode metaprogramAnchor,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForAnnotationType(annotationType, false);
        this.metaprogramAnchor = metaprogramAnchor;
    }
    
    /**
     * Gets the annotation type.  This property's value is assumed to be a normal node.
     * @return The annotation type.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public UnparameterizedTypeNode getAnnotationType()
    {
        getAttribute(LocalAttribute.ANNOTATION_TYPE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.annotationType == null)
        {
            return null;
        } else
        {
            return this.annotationType.getNormalNode();
        }
    }
    
    /**
     * Gets the annotation type.
     * @return The annotation type.
     */
    public NodeUnion<? extends UnparameterizedTypeNode> getUnionForAnnotationType()
    {
        getAttribute(LocalAttribute.ANNOTATION_TYPE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.annotationType == null)
        {
            this.annotationType = new NormalNodeUnion<UnparameterizedTypeNode>(null);
        }
        return this.annotationType;
    }
    
    /**
     * Changes the annotation type.
     * @param annotationType The annotation type.
     */
    public void setAnnotationType(UnparameterizedTypeNode annotationType)
    {
            setAnnotationType(annotationType, true);
            getManager().notifyChange(this);
    }
    
    private void setAnnotationType(UnparameterizedTypeNode annotationType, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ANNOTATION_TYPE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.annotationType != null)
        {
            setAsChild(this.annotationType.getNodeValue(), false);
        }
        this.annotationType = new NormalNodeUnion<UnparameterizedTypeNode>(annotationType);
        setAsChild(annotationType, true);
    }
    
    /**
     * Changes the annotation type.
     * @param annotationType The annotation type.
     */
    public void setUnionForAnnotationType(NodeUnion<? extends UnparameterizedTypeNode> annotationType)
    {
            setUnionForAnnotationType(annotationType, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForAnnotationType(NodeUnion<? extends UnparameterizedTypeNode> annotationType, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ANNOTATION_TYPE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (annotationType == null)
        {
            annotationType = new NormalNodeUnion<UnparameterizedTypeNode>(null);
        }
        if (this.annotationType != null)
        {
            setAsChild(this.annotationType.getNodeValue(), false);
        }
        this.annotationType = annotationType;
        setAsChild(annotationType.getNodeValue(), true);
    }
    
    /**
     * Gets the anchor of a metaprogram attached to this node.
     * @return The anchor of a metaprogram attached to this node.
     */
    public MetaAnnotationMetaprogramAnchorNode getMetaprogramAnchor()
    {
        getAttribute(LocalAttribute.METAPROGRAM_ANCHOR).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        if (this.annotationType.getNodeValue() != null)
        {
            this.annotationType.getNodeValue().receive(visitor);
        }
        if (this.metaprogramAnchor != null)
        {
            this.metaprogramAnchor.receive(visitor);
        }
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receive(visitor);
            }
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
        if (this.annotationType.getNodeValue() != null)
        {
            this.annotationType.getNodeValue().receiveTyped(visitor);
        }
        if (this.metaprogramAnchor != null)
        {
            this.metaprogramAnchor.receiveTyped(visitor);
        }
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receiveTyped(visitor);
            }
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
        list.add(getUnionForAnnotationType());
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
        sb.append(this.getUnionForAnnotationType().getNodeValue() == null? "null" : this.getUnionForAnnotationType().getNodeValue().getClass().getSimpleName());
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
