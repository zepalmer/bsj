package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.InterfaceMemberListNode;

/**
 * Represents the body of an interface declaration.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InterfaceBodyNode extends Node, TypeBodyNode<InterfaceMemberNode>
{
    /**
     * Gets the members of this interface body.
     * @return The members of this interface body.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public InterfaceMemberListNode getMembers() throws ClassCastException;
    
    /**
     * Gets the union object for the members of this interface body.
     * @return A union object representing The members of this interface body.
     */
    public NodeUnion<? extends InterfaceMemberListNode> getUnionForMembers();
    
    /**
     * Changes the members of this interface body.
     * @param members The members of this interface body.
     */
    public void setMembers(InterfaceMemberListNode members);
    
    /**
     * Changes the members of this interface body.
     * @param members The members of this interface body.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForMembers(NodeUnion<? extends InterfaceMemberListNode> members) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public InterfaceBodyNode deepCopy(BsjNodeFactory factory);
    
}
