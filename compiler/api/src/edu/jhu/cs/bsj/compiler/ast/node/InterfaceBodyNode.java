package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * Represents the body of an interface declaration.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
public interface InterfaceBodyNode extends Node
{
    /**
     * Gets the members of this interface body.
     * @return The members of this interface body.
     */
    public ListNode<InterfaceMemberNode> getMembers();

    /**
     * Changes the members of this interface body.
     * @param members The members of this interface body.
     */
    public void setMembers(ListNode<InterfaceMemberNode> members);

}
