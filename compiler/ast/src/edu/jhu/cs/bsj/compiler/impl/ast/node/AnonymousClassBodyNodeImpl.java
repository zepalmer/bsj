package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassMember;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

public class AnonymousClassBodyNodeImpl extends NodeImpl implements AnonymousClassBodyNode
{
    /** The members of this anonymous class body. */
    private ListNode<? extends AnonymousClassMember> members;

    /** General constructor. */
    public AnonymousClassBodyNodeImpl(
            ListNode<? extends AnonymousClassMember> members)
    {
        super();
        this.members = members;
    }

    /**
     * Gets the members of this anonymous class body.
     * @return The members of this anonymous class body.
     */
    public ListNode<? extends AnonymousClassMember> getMembers()
    {
        return this.members;
    }

    /**
     * Changes the members of this anonymous class body.
     * @param members The members of this anonymous class body.
     */
    public void setMembers(ListNode<? extends AnonymousClassMember> members)
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
