package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.ClassMember;

/**
 * Represents the body of a class declaration.
 */
public interface ClassBodyNode extends Node
{
    /**
     * Gets the members of this class body.
     * @return The members of this class body.
     */
    public ListNode<? extends ClassMember> getMembers();

    /**
     * Changes the members of this class body.
     * @param members The members of this class body.
     */
    public void setMembers(ListNode<? extends ClassMember> members);

}
