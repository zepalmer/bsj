package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

public class InterfaceBodyNodeImpl extends NodeImpl implements InterfaceBodyNode
{
    /** The members of this interface body. */
    private ListNode<InterfaceMemberNode> members;

    /** General constructor. */
    public InterfaceBodyNodeImpl(
            ListNode<InterfaceMemberNode> members)
    {
        super();
        this.members = members;
    }

    /**
     * Gets the members of this interface body.
     * @return The members of this interface body.
     */
    public ListNode<InterfaceMemberNode> getMembers()
    {
        return this.members;
    }

    /**
     * Changes the members of this interface body.
     * @param members The members of this interface body.
     */
    public void setMembers(ListNode<InterfaceMemberNode> members)
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
