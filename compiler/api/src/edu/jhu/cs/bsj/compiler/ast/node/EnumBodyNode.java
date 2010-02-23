package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the body of an enum declaration.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface EnumBodyNode extends Node, TypeBodyNode<ClassMemberNode>
{
    /**
     * Gets the enumeration constants.
     * @return The enumeration constants.
     */
    public EnumConstantDeclarationListNode getConstants();

    /**
     * Changes the enumeration constants.
     * @param constants The enumeration constants.
     */
    public void setConstants(EnumConstantDeclarationListNode constants);

    /**
     * Gets the members of the class body part.
     * @return The members of the class body part.
     */
    public ClassMemberListNode getMembers();

    /**
     * Changes the members of the class body part.
     * @param members The members of the class body part.
     */
    public void setMembers(ClassMemberListNode members);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public EnumBodyNode deepCopy(BsjNodeFactory factory);
}
