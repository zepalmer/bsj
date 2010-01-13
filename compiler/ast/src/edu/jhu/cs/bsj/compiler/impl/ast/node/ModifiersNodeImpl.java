package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.Modifier;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;

public class ModifiersNodeImpl extends NodeImpl implements ModifiersNode
{
    /** The annotations modifying the subject. */
    private ListNode<AnnotationNode> annotations;

    /** The modifiers set on the subject. */
    private Set<Modifier> flags;

    /** General constructor. */
    public ModifiersNodeImpl(
            ListNode<AnnotationNode> annotations,
            Set<Modifier> flags)
    {
        super();
        this.annotations = annotations;
        this.flags = flags;
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
     * Gets the modifiers set on the subject.
     * @return The modifiers set on the subject.
     */
    public Set<Modifier> getFlags()
    {
        return this.flags;
    }

    /**
     * Changes the modifiers set on the subject.
     * @param flags The modifiers set on the subject.
     */
    public void setFlags(Set<Modifier> flags)
    {
        this.flags = flags;
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
}
