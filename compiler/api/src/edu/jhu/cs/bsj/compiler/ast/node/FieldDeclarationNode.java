package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A node representing a field declaration.  Constants are represented by this node as well.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface FieldDeclarationNode extends Node, ClassMemberNode,  InterfaceMemberNode,  AnnotationMemberNode,  AnonymousClassMemberNode
{
    /**
     * Gets the modifiers for this field.
     * @return The modifiers for this field.
     */
    public FieldModifiersNode getModifiers();

    /**
     * Changes the modifiers for this field.
     * @param modifiers The modifiers for this field.
     */
    public void setModifiers(FieldModifiersNode modifiers);

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

    /**
     * Gets the associated javadoc comment for this node.
     * @return The associated javadoc comment for this node.
     */
    public JavadocNode getJavadoc();

    /**
     * Changes the associated javadoc comment for this node.
     * @param javadoc The associated javadoc comment for this node.
     */
    public void setJavadoc(JavadocNode javadoc);

}
