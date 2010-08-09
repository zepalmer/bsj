package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
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
     */
    public ClassMemberListNode getMembers();
    
    /**
     * Changes the members of this class body.
     * @param members The members of this class body.
     */
    public void setMembers(ClassMemberListNode members);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ClassBodyNode deepCopy(BsjNodeFactory factory);
    
}
