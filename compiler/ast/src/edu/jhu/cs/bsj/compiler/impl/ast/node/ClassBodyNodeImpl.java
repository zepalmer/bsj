package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.tags.ClassMember;

public class ClassBodyNodeImpl extends NodeImpl implements ClassBodyNode
{
    /** The members of this class body. */
    private ListNode<? extends ClassMember> members;

    /** General constructor. */
    public ClassBodyNodeImpl(
            ListNode<? extends ClassMember> members)
    {
        super();
        this.members = members;
    }

    /**
     * Gets the members of this class body.
     * @return The members of this class body.
     */
    public ListNode<? extends ClassMember> getMembers()
    {
        return this.members;
    }

    /**
     * Changes the members of this class body.
     * @param members The members of this class body.
     */
    public void setMembers(ListNode<? extends ClassMember> members)
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
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
