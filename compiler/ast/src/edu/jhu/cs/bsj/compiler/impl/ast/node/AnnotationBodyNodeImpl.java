package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMember;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

public class AnnotationBodyNodeImpl extends NodeImpl implements AnnotationBodyNode
{
    /** The members of this annotation body. */
    private ListNode<? extends AnnotationMember> members;

    /** General constructor. */
    public AnnotationBodyNodeImpl(
            ListNode<? extends AnnotationMember> members)
    {
        super();
        this.members = members;
    }

    /**
     * Gets the members of this annotation body.
     * @return The members of this annotation body.
     */
    public ListNode<? extends AnnotationMember> getMembers()
    {
        return this.members;
    }

    /**
     * Changes the members of this annotation body.
     * @param members The members of this annotation body.
     */
    public void setMembers(ListNode<? extends AnnotationMember> members)
    {
        if (this.members instanceof NodeImpl)
        {
            ((NodeImpl)this.members).setParent(null);
        }
        this.members = members;
        if (this.members instanceof NodeImpl)
        {
            ((NodeImpl)this.members).setParent(this);
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
        this.members.receive(visitor);
    }
}
