package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the body of an annotation declaration.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
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

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationBodyNode deepCopy(BsjNodeFactory factory);
}
