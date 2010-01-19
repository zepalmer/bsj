package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ModifiersNodeImpl extends NodeImpl implements ModifiersNode
{
    /** The annotations modifying the subject. */
    private ListNode<AnnotationNode> annotations;

    /** General constructor. */
    protected ModifiersNodeImpl(
            ListNode<AnnotationNode> annotations)
    {
        super();
        this.annotations = annotations;
    }

    /**
     * Gets the annotations modifying the subject.
     * @return The annotations modifying the subject.
     */
    public ListNode<AnnotationNode> getAnnotations()
    {
        return this.annotations;
    }

    /**
     * Changes the annotations modifying the subject.
     * @param annotations The annotations modifying the subject.
     */
    public void setAnnotations(ListNode<AnnotationNode> annotations)
    {
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
        this.annotations.receive(visitor);
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
        this.annotations.receiveTyped(visitor);
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
        visitor.visitNodeStart(this);
        visitor.visitModifiersNodeStart(this);
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
        sb.append("annotations=");
        sb.append(this.annotations == null? "null" : this.annotations.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
