package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the body of an interface declaration.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InterfaceBodyNode extends Node, TypeBodyNode<InterfaceMemberNode>
{
    /**
     * Gets the members of this interface body.
     * @return The members of this interface body.
     */
    public InterfaceMemberListNode getMembers();
    
    /**
     * Changes the members of this interface body.
     * @param members The members of this interface body.
     */
    public void setMembers(InterfaceMemberListNode members);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public InterfaceBodyNode deepCopy(BsjNodeFactory factory);
}
