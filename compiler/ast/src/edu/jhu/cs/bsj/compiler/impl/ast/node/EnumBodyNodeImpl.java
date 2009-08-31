package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.tags.ClassMember;

public class EnumBodyNodeImpl extends NodeImpl implements EnumBodyNode
{
    /** The enumeration constants. */
    private ListNode<? extends EnumConstantDeclarationNode> constants;

    /** The members of the class body part. */
    private ListNode<? extends ClassMember> members;

    /** General constructor. */
    public EnumBodyNodeImpl(
            ListNode<? extends EnumConstantDeclarationNode> constants,
            ListNode<? extends ClassMember> members)
    {
        super();
        this.constants = constants;
        this.members = members;
    }

    /**
     * Gets the enumeration constants.
     * @return The enumeration constants.
     */
    public ListNode<? extends EnumConstantDeclarationNode> getConstants()
    {
        return this.constants;
    }

    /**
     * Changes the enumeration constants.
     * @param constants The enumeration constants.
     */
    public void setConstants(ListNode<? extends EnumConstantDeclarationNode> constants)
    {
        this.constants = constants;
    }

    /**
     * Gets the members of the class body part.
     * @return The members of the class body part.
     */
    public ListNode<? extends ClassMember> getMembers()
    {
        return this.members;
    }

    /**
     * Changes the members of the class body part.
     * @param members The members of the class body part.
     */
    public void setMembers(ListNode<? extends ClassMember> members)
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
