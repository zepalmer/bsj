package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AnnotationNodeSetAnnotationTypePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.AnnotationNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class AnnotationNodeImpl extends NodeImpl implements AnnotationNode
{
    /** The annotation type. */
    private NodeUnion<? extends UnparameterizedTypeNode> annotationType;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<AnnotationNodeProperties> populatedProperties;
    
    /** General constructor. */
    protected AnnotationNodeImpl(
            NodeUnion<? extends UnparameterizedTypeNode> annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetAnnotationType(annotationType);
    }
    
    /** Proxy constructor. */
    protected AnnotationNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, AnnotationNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(AnnotationNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected AnnotationNode getBackingNode()
    {
        return (AnnotationNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the annotationType value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkAnnotationTypeWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AnnotationNodeProperties.ANNOTATION_TYPE))
            return;
        this.populatedProperties.add(AnnotationNodeProperties.ANNOTATION_TYPE);
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
            super.recordEdit(new AnnotationNodeSetAnnotationTypePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), annotationType.getNodeValue() == null ? null : annotationType.getNodeValue().getUid()));
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
        visitor.visitAnnotationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitAnnotationNodeStop(this);
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
        return list;
    }
    
    /**
     * Produces a mutable map of this node's children.  Modifying this map will have no
     * effect on this node.
     * @return A mapping of the node's children.
     */
    @Override
    public Map<String,Object> getChildMap()
    {
        Map<String,Object> map = super.getChildMap();
        map.put("annotationType", getUnionForAnnotationType());
        return map;
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
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + (this.getStartLocation() != null ? this.getStartLocation().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + (this.getStopLocation() != null ? this.getStopLocation().getClass().getSimpleName() : "null"));
        sb.append(']');
        return sb.toString();
    }
    
    
    
}
