package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

public class AnnotationBodyNodeImpl extends NodeImpl implements AnnotationBodyNode
{
    /** The members of this annotation body. */
    private ListNode<AnnotationMemberNode> members;

    /** General constructor. */
    public AnnotationBodyNodeImpl(
            ListNode<AnnotationMemberNode> members)
    {
        super();
        this.members = members;
    }

    /**
     * Gets the members of this annotation body.
     * @return The members of this annotation body.
     */
    public ListNode<AnnotationMemberNode> getMembers()
    {
        return this.members;
    }

    /**
     * Changes the members of this annotation body.
     * @param members The members of this annotation body.
     */
    public void setMembers(ListNode<AnnotationMemberNode> members)
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
