package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents the body of an interface declaration.
 */
public interface InterfaceBodyNode extends Node
{
    /**
     * Gets the members of this interface body.
     * @return The members of this interface body.
     */
    public ListNode<? extends InterfaceMemberNode> getMembers();

    /**
     * Changes the members of this interface body.
     * @param members The members of this interface body.
     */
    public void setMembers(ListNode<? extends InterfaceMemberNode> members);

}
