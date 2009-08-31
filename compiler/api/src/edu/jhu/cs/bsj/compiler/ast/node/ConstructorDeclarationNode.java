package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.ClassMember;

/**
 * A node representing a constructor declaration, as in:
 * <pre>
 *     <i>modifiers typeParams typeName</i>(<i>parameter...</i>) throws <i>expr...</i>
 *         <i>body</i>
 * </pre>
 */
public interface ConstructorDeclarationNode extends Node, ClassMember
{
    /**
     * Gets the body of this constructor.
     * @return The body of this constructor.
     */
    public BlockStatementNode getBody();

    /**
     * Changes the body of this constructor.
     * @param body The body of this constructor.
     */
    public void setBody(BlockStatementNode body);

    /**
     * Gets the modifiers for this constructor.
     * @return The modifiers for this constructor.
     */
    public ModifiersNode getModifiers();

    /**
     * Changes the modifiers for this constructor.
     * @param modifiers The modifiers for this constructor.
     */
    public void setModifiers(ModifiersNode modifiers);

    /**
     * Gets the parameters declared by this constructor.
     * @return The parameters declared by this constructor.
     */
    public ListNode<? extends VariableNode> getParameters();

    /**
     * Changes the parameters declared by this constructor.
     * @param parameters The parameters declared by this constructor.
     */
    public void setParameters(ListNode<? extends VariableNode> parameters);

    /**
     * Gets the types of exceptions thrown by this constructor.
     * @return The types of exceptions thrown by this constructor.
     */
    public ListNode<? extends DeclaredTypeNode> getThrowTypes();

    /**
     * Changes the types of exceptions thrown by this constructor.
     * @param throwTypes The types of exceptions thrown by this constructor.
     */
    public void setThrowTypes(ListNode<? extends DeclaredTypeNode> throwTypes);

    /**
     * Gets this constructor's applicable type parameters.
     * @return This constructor's applicable type parameters.
     */
    public ListNode<? extends TypeParameterNode> getTypeParameters();

    /**
     * Changes this constructor's applicable type parameters.
     * @param typeParameters This constructor's applicable type parameters.
     */
    public void setTypeParameters(ListNode<? extends TypeParameterNode> typeParameters);

}
