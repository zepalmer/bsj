package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.EnumConstantDeclarationListNode;

/**
 * Represents the body of an enum declaration.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface EnumBodyNode extends Node, TypeBodyNode<ClassMemberNode>
{
    /**
     * Gets the enumeration constants.
     * @return The enumeration constants.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public EnumConstantDeclarationListNode getConstants()throws ClassCastException;
    
    /**
     * Gets the union object for the enumeration constants.
     * @return A union object representing The enumeration constants.
     */
    public NodeUnion<? extends EnumConstantDeclarationListNode> getUnionForConstants();
    
    /**
     * Changes the enumeration constants.
     * @param constants The enumeration constants.
     */
    public void setConstants(EnumConstantDeclarationListNode constants);
    
    /**
     * Changes the enumeration constants.
     * @param constants The enumeration constants.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForConstants(NodeUnion<? extends EnumConstantDeclarationListNode> constants) throws NullPointerException;
    
    /**
     * Gets the members of the class body part.
     * @return The members of the class body part.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ClassMemberListNode getMembers()throws ClassCastException;
    
    /**
     * Gets the union object for the members of the class body part.
     * @return A union object representing The members of the class body part.
     */
    public NodeUnion<? extends ClassMemberListNode> getUnionForMembers();
    
    /**
     * Changes the members of the class body part.
     * @param members The members of the class body part.
     */
    public void setMembers(ClassMemberListNode members);
    
    /**
     * Changes the members of the class body part.
     * @param members The members of the class body part.
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
    public EnumBodyNode deepCopy(BsjNodeFactory factory);
    
}
