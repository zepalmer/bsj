package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing a constructor declaration, as in:
 * <pre>
 *     <i>modifiers typeParams typeName</i>(<i>parameter...</i>) throws <i>expr...</i>
 *         <i>body</i>
 * </pre>
 * See {@link MethodDeclarationNode} for more information.
 */
public interface ConstructorDeclarationNode extends Node, ClassMember
{
    /**
     * Gets the body of this constructor.
     * @return The body of this constructor.
     */
    public ConstructorBodyNode getBody();

    /**
     * Changes the body of this constructor.
     * @param body The body of this constructor.
     */
    public void setBody(ConstructorBodyNode body);

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
     * Gets the vararg parameter declared by this method.
     * @return The vararg parameter declared by this method.
     */
    public VariableNode getVarargParameter();

    /**
     * Changes the vararg parameter declared by this method.
     * @param varargParameter The vararg parameter declared by this method.
     */
    public void setVarargParameter(VariableNode varargParameter);

    /**
     * Gets the types of exceptions thrown by this constructor.
     * @return The types of exceptions thrown by this constructor.
     */
    public ListNode<? extends RawTypeNode> getThrowTypes();

    /**
     * Changes the types of exceptions thrown by this constructor.
     * @param throwTypes The types of exceptions thrown by this constructor.
     */
    public void setThrowTypes(ListNode<? extends RawTypeNode> throwTypes);

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
