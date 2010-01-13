package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

public class ClassBodyNodeImpl extends NodeImpl implements ClassBodyNode
{
    /** The members of this class body. */
    private ListNode<ClassMemberNode> members;

    /** General constructor. */
    public ClassBodyNodeImpl(
            ListNode<ClassMemberNode> members)
    {
        super();
        this.members = members;
    }

    /**
     * Gets the members of this class body.
     * @return The members of this class body.
     */
    public ListNode<ClassMemberNode> getMembers()
    {
        return this.members;
    }

    /**
     * Changes the members of this class body.
     * @param members The members of this class body.
     */
    public void setMembers(ListNode<ClassMemberNode> members)
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
