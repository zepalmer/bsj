package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.ClassMember;
import edu.jhu.cs.bsj.compiler.ast.tags.InterfaceMember;

/**
 * A node representing a method declaration, as in:
 * <pre>
 *     <i>modifiers typeParams type name</i>(<i>parameter...</i>) throws <i>expr...</i>
 *         <i>body</i>
 * </pre>
 */
public interface MethodDeclarationNode extends Node, ClassMember,  InterfaceMember
{
    /**
     * Gets the body of this method.
     * @return The body of this method.
     */
    public BlockStatementNode getBody();

    /**
     * Changes the body of this method.
     * @param body The body of this method.
     */
    public void setBody(BlockStatementNode body);

    /**
     * Gets the modifiers for this method.
     * @return The modifiers for this method.
     */
    public ModifiersNode getModifiers();

    /**
     * Changes the modifiers for this method.
     * @param modifiers The modifiers for this method.
     */
    public void setModifiers(ModifiersNode modifiers);

    /**
     * Gets this method's name.
     * @return This method's name.
     */
    public IdentifierNode getName();

    /**
     * Changes this method's name.
     * @param name This method's name.
     */
    public void setName(IdentifierNode name);

    /**
     * Gets the parameters declared by this method.
     * @return The parameters declared by this method.
     */
    public ListNode<? extends VariableNode> getParameters();

    /**
     * Changes the parameters declared by this method.
     * @param parameters The parameters declared by this method.
     */
    public void setParameters(ListNode<? extends VariableNode> parameters);

    /**
     * Gets the type of value returned.
     * @return The type of value returned.
     */
    public TypeNode getReturnType();

    /**
     * Changes the type of value returned.
     * @param returnType The type of value returned.
     */
    public void setReturnType(TypeNode returnType);

    /**
     * Gets the types of exceptions thrown by this method.
     * @return The types of exceptions thrown by this method.
     */
    public ListNode<? extends DeclaredTypeNode> getThrowTypes();

    /**
     * Changes the types of exceptions thrown by this method.
     * @param throwTypes The types of exceptions thrown by this method.
     */
    public void setThrowTypes(ListNode<? extends DeclaredTypeNode> throwTypes);

    /**
     * Gets this method's applicable type parameters.
     * @return This method's applicable type parameters.
     */
    public ListNode<? extends TypeParameterNode> getTypeParameters();

    /**
     * Changes this method's applicable type parameters.
     * @param typeParameters This method's applicable type parameters.
     */
    public void setTypeParameters(ListNode<? extends TypeParameterNode> typeParameters);

}
