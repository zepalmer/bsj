package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.AnnotationMember;

/**
 * Represents the body of an annotation declaration.
 */
public interface AnnotationBodyNode extends Node
{
    /**
     * Gets the members of this annotation body.
     * @return The members of this annotation body.
     */
    public ListNode<? extends AnnotationMember> getMembers();

    /**
     * Changes the members of this annotation body.
     * @param members The members of this annotation body.
     */
    public void setMembers(ListNode<? extends AnnotationMember> members);

}
