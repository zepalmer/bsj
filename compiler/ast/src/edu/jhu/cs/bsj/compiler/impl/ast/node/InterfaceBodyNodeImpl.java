package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.tags.InterfaceMember;

public class InterfaceBodyNodeImpl extends NodeImpl implements InterfaceBodyNode
{
    /** The members of this interface body. */
    private ListNode<? extends InterfaceMember> members;

    /** General constructor. */
    public InterfaceBodyNodeImpl(
            ListNode<? extends InterfaceMember> members)
    {
        super();
        this.members = members;
    }

    /**
     * Gets the members of this interface body.
     * @return The members of this interface body.
     */
    public ListNode<? extends InterfaceMember> getMembers()
    {
        return this.members;
    }

    /**
     * Changes the members of this interface body.
     * @param members The members of this interface body.
     */
    public void setMembers(ListNode<? extends InterfaceMember> members)
    {
        this.members = members;
    }

    /**
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
