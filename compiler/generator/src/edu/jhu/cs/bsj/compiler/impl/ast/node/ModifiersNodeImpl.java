package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ModifiersNodeImpl extends NodeImpl implements ModifiersNode
{
    /** The meta-annotations modifying the subject. */
    private MetaAnnotationListNode metaAnnotations;
    
    /** The annotations modifying the subject. */
    private AnnotationListNode annotations;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the metaAnnotations property. */
        META_ANNOTATIONS,
        /** Attribute for the annotations property. */
        ANNOTATIONS,
    }
    
    /** General constructor. */
    protected ModifiersNodeImpl(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setMetaAnnotations(metaAnnotations, false);
        setAnnotations(annotations, false);
    }
    
    /**
     * Gets the meta-annotations modifying the subject.
     * @return The meta-annotations modifying the subject.
     */
    public MetaAnnotationListNode getMetaAnnotations()
    {
        recordAccess(LocalAttribute.META_ANNOTATIONS, Attribute.AccessType.READ);
        return this.metaAnnotations;
    }
    
    /**
     * Changes the meta-annotations modifying the subject.
     * @param metaAnnotations The meta-annotations modifying the subject.
     */
    public void setMetaAnnotations(MetaAnnotationListNode metaAnnotations)
    {
            setMetaAnnotations(metaAnnotations, true);
    }
    
    private void setMetaAnnotations(MetaAnnotationListNode metaAnnotations, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
        }
        recordAccess(LocalAttribute.META_ANNOTATIONS, Attribute.AccessType.WRITE);
        if (this.metaAnnotations instanceof NodeImpl)
        {
            ((NodeImpl)this.metaAnnotations).setParent(null);
        }
        this.metaAnnotations = metaAnnotations;
        if (this.metaAnnotations instanceof NodeImpl)
        {
            ((NodeImpl)this.metaAnnotations).setParent(this);
        }
    }
    
    /**
     * Gets the annotations modifying the subject.
     * @return The annotations modifying the subject.
     */
    public AnnotationListNode getAnnotations()
    {
        recordAccess(LocalAttribute.ANNOTATIONS, Attribute.AccessType.READ);
        return this.annotations;
    }
    
    /**
     * Changes the annotations modifying the subject.
     * @param annotations The annotations modifying the subject.
     */
    public void setAnnotations(AnnotationListNode annotations)
    {
            setAnnotations(annotations, true);
    }
    
    private void setAnnotations(AnnotationListNode annotations, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
        }
        recordAccess(LocalAttribute.ANNOTATIONS, Attribute.AccessType.WRITE);
        if (this.annotations instanceof NodeImpl)
        {
            ((NodeImpl)this.annotations).setParent(null);
        }
        this.annotations = annotations;
        if (this.annotations instanceof NodeImpl)
        {
            ((NodeImpl)this.annotations).setParent(this);
        }
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
        if (this.metaAnnotations != null)
        {
            this.metaAnnotations.receive(visitor);
        }
        if (this.annotations != null)
        {
            this.annotations.receive(visitor);
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
        if (this.metaAnnotations != null)
        {
            this.metaAnnotations.receiveTyped(visitor);
        }
        if (this.annotations != null)
        {
            this.annotations.receiveTyped(visitor);
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitModifiersNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
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
        list.add(getMetaAnnotations());
        list.add(getAnnotations());
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
        sb.append(this.getMetaAnnotations() == null? "null" : this.getMetaAnnotations().getClass().getSimpleName());
        sb.append(',');
        sb.append("annotations=");
        sb.append(this.getAnnotations() == null? "null" : this.getAnnotations().getClass().getSimpleName());
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
