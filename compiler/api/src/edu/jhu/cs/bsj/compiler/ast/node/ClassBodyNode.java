package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;

/**
 * Represents the body of a class declaration.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ClassBodyNode extends Node, TypeBodyNode<ClassMemberNode>
{
    /**
     * Gets the members of this class body.
     * @return The members of this class body.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ClassMemberListNode getMembers()throws ClassCastException;
    
    /**
     * Gets the union object for the members of this class body.
     * @return A union object representing The members of this class body.
     */
    public NodeUnion<? extends ClassMemberListNode> getUnionForMembers();
    
    /**
     * Changes the members of this class body.
     * @param members The members of this class body.
     */
    public void setMembers(ClassMemberListNode members);
    
    /**
     * Changes the members of this class body.
     * @param members The members of this class body.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForMembers(NodeUnion<? extends ClassMemberListNode> members) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ClassBodyNode deepCopy(BsjNodeFactory factory);
    
}
