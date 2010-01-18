package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class AnnotationAnnotationValueNodeImpl extends NodeImpl implements AnnotationAnnotationValueNode
{
    /** The annotation. */
    private AnnotationNode annotation;

    /** General constructor. */
    public AnnotationAnnotationValueNodeImpl(
            AnnotationNode annotation)
    {
        super();
        this.annotation = annotation;
    }

    /**
     * Gets the annotation.
     * @return The annotation.
     */
    public AnnotationNode getAnnotation()
    {
        return this.annotation;
    }

    /**
     * Changes the annotation.
     * @param annotation The annotation.
     */
    public void setAnnotation(AnnotationNode annotation)
    {
        if (this.annotation instanceof NodeImpl)
        {
            ((NodeImpl)this.annotation).setParent(null);
        }
        this.annotation = annotation;
        if (this.annotation instanceof NodeImpl)
        {
            ((NodeImpl)this.annotation).setParent(this);
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
        this.annotation.receive(visitor);
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
        this.annotation.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitAnnotationAnnotationValueNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitAnnotationValueNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitAnnotationValueNodeStop(this);
        visitor.visitNodeStart(this);
        visitor.visitAnnotationAnnotationValueNodeStart(this, true);
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
        list.add(this.annotation);
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
        sb.append("annotation=");
        sb.append(this.annotation == null? "null" : this.annotation.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
