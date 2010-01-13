package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents the body of a class declaration.
 */
public interface ClassBodyNode extends Node
{
    /**
     * Gets the members of this class body.
     * @return The members of this class body.
     */
    public ListNode<ClassMemberNode> getMembers();

    /**
     * Changes the members of this class body.
     * @param members The members of this class body.
     */
    public void setMembers(ListNode<ClassMemberNode> members);

}
