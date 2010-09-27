package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationMemberListNode;

/**
 * Represents the body of an annotation declaration.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnnotationBodyNode extends Node, TypeBodyNode<AnnotationMemberNode>
{
    /**
     * Gets the members of this annotation body.
     * @return The members of this annotation body.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public AnnotationMemberListNode getMembers() throws ClassCastException;
    
    /**
     * Gets the union object for the members of this annotation body.
     * @return A union object representing The members of this annotation body.
     */
    public NodeUnion<? extends AnnotationMemberListNode> getUnionForMembers();
    
    /**
     * Changes the members of this annotation body.
     * @param members The members of this annotation body.
     */
    public void setMembers(AnnotationMemberListNode members);
    
    /**
     * Changes the members of this annotation body.
     * @param members The members of this annotation body.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForMembers(NodeUnion<? extends AnnotationMemberListNode> members) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationBodyNode deepCopy(BsjNodeFactory factory);
    
}
