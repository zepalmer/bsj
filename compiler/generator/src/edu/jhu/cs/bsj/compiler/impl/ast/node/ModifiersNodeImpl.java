package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ModifiersNodeImpl extends NodeImpl implements ModifiersNode
{
    /** The meta-annotations modifying the subject. */
    private NodeUnion<? extends MetaAnnotationListNode> metaAnnotations;
    
    /** The annotations modifying the subject. */
    private NodeUnion<? extends AnnotationListNode> annotations;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(ModifiersNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the metaAnnotations property. */
        META_ANNOTATIONS,
        /** Attribute identifier for the annotations property. */
        ANNOTATIONS,
    }
    
    /** General constructor. */
    protected ModifiersNodeImpl(
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForMetaAnnotations(metaAnnotations, false);
        setUnionForAnnotations(annotations, false);
    }
    
    /**
     * Gets the meta-annotations modifying the subject.  This property's value is assumed to be a normal node.
     * @return The meta-annotations modifying the subject.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public MetaAnnotationListNode getMetaAnnotations()
    {
        getAttribute(LocalAttribute.META_ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.metaAnnotations == null)
        {
            return null;
        } else
        {
            return this.metaAnnotations.getNormalNode();
        }
    }
    
    /**
     * Gets the meta-annotations modifying the subject.
     * @return The meta-annotations modifying the subject.
     */
    public NodeUnion<? extends MetaAnnotationListNode> getUnionForMetaAnnotations()
    {
        getAttribute(LocalAttribute.META_ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.metaAnnotations == null)
        {
            this.metaAnnotations = new NormalNodeUnion<MetaAnnotationListNode>(null);
        }
        return this.metaAnnotations;
    }
    
    /**
     * Changes the meta-annotations modifying the subject.
     * @param metaAnnotations The meta-annotations modifying the subject.
     */
    public void setMetaAnnotations(MetaAnnotationListNode metaAnnotations)
    {
            setMetaAnnotations(metaAnnotations, true);
            getManager().notifyChange(this);
    }
    
    private void setMetaAnnotations(MetaAnnotationListNode metaAnnotations, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.META_ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.metaAnnotations != null)
        {
            setAsChild(this.metaAnnotations.getNodeValue(), false);
        }
        this.metaAnnotations = new NormalNodeUnion<MetaAnnotationListNode>(metaAnnotations);
        setAsChild(metaAnnotations, true);
    }
    
    /**
     * Changes the meta-annotations modifying the subject.
     * @param metaAnnotations The meta-annotations modifying the subject.
     */
    public void setUnionForMetaAnnotations(NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
            setUnionForMetaAnnotations(metaAnnotations, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForMetaAnnotations(NodeUnion<? extends MetaAnnotationListNode> metaAnnotations, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.META_ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (metaAnnotations == null)
        {
            metaAnnotations = new NormalNodeUnion<MetaAnnotationListNode>(null);
        }
        if (this.metaAnnotations != null)
        {
            setAsChild(this.metaAnnotations.getNodeValue(), false);
        }
        this.metaAnnotations = metaAnnotations;
        setAsChild(metaAnnotations.getNodeValue(), true);
    }
    
    /**
     * Gets the annotations modifying the subject.  This property's value is assumed to be a normal node.
     * @return The annotations modifying the subject.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public AnnotationListNode getAnnotations()
    {
        getAttribute(LocalAttribute.ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.annotations == null)
        {
            return null;
        } else
        {
            return this.annotations.getNormalNode();
        }
    }
    
    /**
     * Gets the annotations modifying the subject.
     * @return The annotations modifying the subject.
     */
    public NodeUnion<? extends AnnotationListNode> getUnionForAnnotations()
    {
        getAttribute(LocalAttribute.ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.annotations == null)
        {
            this.annotations = new NormalNodeUnion<AnnotationListNode>(null);
        }
        return this.annotations;
    }
    
    /**
     * Changes the annotations modifying the subject.
     * @param annotations The annotations modifying the subject.
     */
    public void setAnnotations(AnnotationListNode annotations)
    {
            setAnnotations(annotations, true);
            getManager().notifyChange(this);
    }
    
    private void setAnnotations(AnnotationListNode annotations, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.annotations != null)
        {
            setAsChild(this.annotations.getNodeValue(), false);
        }
        this.annotations = new NormalNodeUnion<AnnotationListNode>(annotations);
        setAsChild(annotations, true);
    }
    
    /**
     * Changes the annotations modifying the subject.
     * @param annotations The annotations modifying the subject.
     */
    public void setUnionForAnnotations(NodeUnion<? extends AnnotationListNode> annotations)
    {
            setUnionForAnnotations(annotations, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForAnnotations(NodeUnion<? extends AnnotationListNode> annotations, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (annotations == null)
        {
            annotations = new NormalNodeUnion<AnnotationListNode>(null);
        }
        if (this.annotations != null)
        {
            setAsChild(this.annotations.getNodeValue(), false);
        }
        this.annotations = annotations;
        setAsChild(annotations.getNodeValue(), true);
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
        if (this.metaAnnotations.getNodeValue() != null)
        {
            this.metaAnnotations.getNodeValue().receive(visitor);
        }
        if (this.annotations.getNodeValue() != null)
        {
            this.annotations.getNodeValue().receive(visitor);
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
        if (this.metaAnnotations.getNodeValue() != null)
        {
            this.metaAnnotations.getNodeValue().receiveTyped(visitor);
        }
        if (this.annotations.getNodeValue() != null)
        {
            this.annotations.getNodeValue().receiveTyped(visitor);
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
        visitor.visitModifiersNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitMetaAnnotatableNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitMetaAnnotatableNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitModifiersNodeStop(this);
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
        list.add(getUnionForAnnotations());
        list.add(getUnionForMetaAnnotations());
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
        sb.append("metaAnnotations=");
        sb.append(this.getUnionForMetaAnnotations().getNodeValue() == null? "null" : this.getUnionForMetaAnnotations().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("annotations=");
        sb.append(this.getUnionForAnnotations().getNodeValue() == null? "null" : this.getUnionForAnnotations().getNodeValue().getClass().getSimpleName());
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
