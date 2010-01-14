package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

public class AnonymousClassBodyNodeImpl extends NodeImpl implements AnonymousClassBodyNode
{
    /** The members of this anonymous class body. */
    private ListNode<AnonymousClassMemberNode> members;

    /** General constructor. */
    public AnonymousClassBodyNodeImpl(
            ListNode<AnonymousClassMemberNode> members)
    {
        super();
        this.members = members;
    }

    /**
     * Gets the members of this anonymous class body.
     * @return The members of this anonymous class body.
     */
    public ListNode<AnonymousClassMemberNode> getMembers()
    {
        return this.members;
    }

    /**
     * Changes the members of this anonymous class body.
     * @param members The members of this anonymous class body.
     */
    public void setMembers(ListNode<AnonymousClassMemberNode> members)
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

    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(this.members);
        return list;
    }
}
