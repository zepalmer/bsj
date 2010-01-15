package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * Represents the body of an annotation declaration.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
public interface AnnotationBodyNode extends Node
{
    /**
     * Gets the members of this annotation body.
     * @return The members of this annotation body.
     */
    public ListNode<AnnotationMemberNode> getMembers();

    /**
     * Changes the members of this annotation body.
     * @param members The members of this annotation body.
     */
    public void setMembers(ListNode<AnnotationMemberNode> members);

}
