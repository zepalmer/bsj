package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

public class EnumBodyNodeImpl extends NodeImpl implements EnumBodyNode
{
    /** The enumeration constants. */
    private ListNode<EnumConstantDeclarationNode> constants;

    /** The members of the class body part. */
    private ListNode<ClassMemberNode> members;

    /** General constructor. */
    public EnumBodyNodeImpl(
            ListNode<EnumConstantDeclarationNode> constants,
            ListNode<ClassMemberNode> members)
    {
        super();
        this.constants = constants;
        this.members = members;
    }

    /**
     * Gets the enumeration constants.
     * @return The enumeration constants.
     */
    public ListNode<EnumConstantDeclarationNode> getConstants()
    {
        return this.constants;
    }

    /**
     * Changes the enumeration constants.
     * @param constants The enumeration constants.
     */
    public void setConstants(ListNode<EnumConstantDeclarationNode> constants)
    {
        if (this.constants instanceof NodeImpl)
        {
            ((NodeImpl)this.constants).setParent(null);
        }
        this.constants = constants;
        if (this.constants instanceof NodeImpl)
        {
            ((NodeImpl)this.constants).setParent(this);
        }
    }

    /**
     * Gets the members of the class body part.
     * @return The members of the class body part.
     */
    public ListNode<ClassMemberNode> getMembers()
    {
        return this.members;
    }

    /**
     * Changes the members of the class body part.
     * @param members The members of the class body part.
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
        this.constants.receive(visitor);
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
        list.add(this.constants);
        list.add(this.members);
        return list;
    }
}
