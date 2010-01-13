package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents the body of an anonymous class declaration.  This body is distinct from {@link ClassBodyNode} in that
 * it does not permit constructors.  There is no corresponding <tt>AnonymousClassDeclarationNode</tt> because the
 * expression which contains this body implicitly stands as the declaration of that type.
 */
public interface AnonymousClassBodyNode extends Node
{
    /**
     * Gets the members of this anonymous class body.
     * @return The members of this anonymous class body.
     */
    public ListNode<? extends AnonymousClassMember> getMembers();

    /**
     * Changes the members of this anonymous class body.
     * @param members The members of this anonymous class body.
     */
    public void setMembers(ListNode<? extends AnonymousClassMember> members);

}
