package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing a field declaration.  Constants are represented by this node as well.
 */
public interface FieldDeclarationNode extends Node, ClassMemberNode,  InterfaceMemberNode,  AnnotationMemberNode,  AnonymousClassMemberNode
{
    /**
     * Gets the modifiers for this field.
     * @return The modifiers for this field.
     */
    public ModifiersNode getModifiers();

    /**
     * Changes the modifiers for this field.
     * @param modifiers The modifiers for this field.
     */
    public void setModifiers(ModifiersNode modifiers);

    /**
     * Gets the variable declarators for this node.
     * @return The variable declarators for this node.
     */
    public ListNode<VariableDeclaratorNode> getDeclarators();

    /**
     * Changes the variable declarators for this node.
     * @param declarators The variable declarators for this node.
     */
    public void setDeclarators(ListNode<VariableDeclaratorNode> declarators);

}
