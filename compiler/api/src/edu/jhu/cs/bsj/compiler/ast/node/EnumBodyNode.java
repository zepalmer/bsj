package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents the body of an enum declaration.
 */
public interface EnumBodyNode extends Node
{
    /**
     * Gets the enumeration constants.
     * @return The enumeration constants.
     */
    public ListNode<EnumConstantDeclarationNode> getConstants();

    /**
     * Changes the enumeration constants.
     * @param constants The enumeration constants.
     */
    public void setConstants(ListNode<EnumConstantDeclarationNode> constants);

    /**
     * Gets the members of the class body part.
     * @return The members of the class body part.
     */
    public ListNode<ClassMemberNode> getMembers();

    /**
     * Changes the members of the class body part.
     * @param members The members of the class body part.
     */
    public void setMembers(ListNode<ClassMemberNode> members);

}
