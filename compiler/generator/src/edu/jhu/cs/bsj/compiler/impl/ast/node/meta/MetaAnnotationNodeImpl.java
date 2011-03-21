package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MetaAnnotationNodeSetAnnotationTypePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.MetaAnnotationNodeProperties;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MetaAnnotationNodeImpl extends NodeImpl implements MetaAnnotationNode
{
    /** The annotation type. */
    private NodeUnion<? extends UnparameterizedTypeNode> annotationType;
    
    /** The anchor of a metaprogram attached to this node. */
    private MetaAnnotationMetaprogramAnchorNode metaprogramAnchor;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<MetaAnnotationNodeProperties> populatedProperties;
    
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
        this.populatedProperties = null;
        doSetAnnotationType(annotationType);
        doSetMetaprogramAnchor(metaprogramAnchor);
    }
    
    /** Proxy constructor. */
    protected MetaAnnotationNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, MetaAnnotationNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(MetaAnnotationNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected MetaAnnotationNode getBackingNode()
    {
        return (MetaAnnotationNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the annotationType value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkAnnotationTypeWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MetaAnnotationNodeProperties.ANNOTATION_TYPE))
            return;
        this.populatedProperties.add(MetaAnnotationNodeProperties.ANNOTATION_TYPE);
        NodeUnion<? extends UnparameterizedTypeNode> union = this.getBackingNode().getUnionForAnnotationType();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeUnparameterizedTypeNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.annotationType = union;
    }
    
    /**
     * Ensures that the metaprogramAnchor value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkMetaprogramAnchorWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MetaAnnotationNodeProperties.METAPROGRAM_ANCHOR))
            return;
        this.populatedProperties.add(MetaAnnotationNodeProperties.METAPROGRAM_ANCHOR);
        this.metaprogramAnchor = this.getProxyFactory().makeMetaAnnotationMetaprogramAnchorNode(
                this.getBackingNode().getMetaprogramAnchor());
    }
    
    /**
     * Gets the annotation type.  This property's value is assumed to be a normal node.
     * @return The annotation type.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public UnparameterizedTypeNode getAnnotationType()
    {
        checkAnnotationTypeWrapped();
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
        checkAnnotationTypeWrapped();
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
        checkAnnotationTypeWrapped();
        this.setUnionForAnnotationType(new NormalNodeUnion<UnparameterizedTypeNode>(annotationType));
    }
    
    /**
     * Changes the annotation type.
     * @param annotationType The annotation type.
     */
    public void setUnionForAnnotationType(NodeUnion<? extends UnparameterizedTypeNode> annotationType)
    {
        checkAnnotationTypeWrapped();
        this.getManager().assertMutatable(this);
        this.doSetAnnotationType(annotationType);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MetaAnnotationNodeSetAnnotationTypePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), annotationType.getNodeValue() == null ? null : annotationType.getNodeValue().getUid()));
    }
    
    private void doSetAnnotationType(NodeUnion<? extends UnparameterizedTypeNode> annotationType)
    {
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
        checkMetaprogramAnchorWrapped();
        return this.metaprogramAnchor;
    }
    
    private void doSetMetaprogramAnchor(MetaAnnotationMetaprogramAnchorNode metaprogramAnchor)
    {
        if (this.metaprogramAnchor != null)
            setAsChild(this.metaprogramAnchor, false);
        this.metaprogramAnchor = metaprogramAnchor;
        if (this.metaprogramAnchor != null)
            setAsChild(this.metaprogramAnchor, true);
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
        if (this.getUnionForAnnotationType().getNodeValue() != null)
        {
            this.getUnionForAnnotationType().getNodeValue().receive(visitor);
        }
        if (this.getMetaprogramAnchor() != null)
        {
            this.getMetaprogramAnchor().receive(visitor);
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
        if (this.getUnionForAnnotationType().getNodeValue() != null)
        {
            this.getUnionForAnnotationType().getNodeValue().receiveTyped(visitor);
        }
        if (this.getMetaprogramAnchor() != null)
        {
            this.getMetaprogramAnchor().receiveTyped(visitor);
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
        sb.append('#');
        sb.append(this.getUid());
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
