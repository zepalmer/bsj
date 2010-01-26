package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A node representing a method declaration, as in:
 * <pre>
 *     <i>modifiers typeParams type name</i>(<i>parameter...</i>) throws <i>expr...</i>
 *         <i>body</i>
 * </pre>
 * Note that the vararg parameter is used in cases where a variable argument is used, such as in
 * <pre>
 *     public void foo(String... vararg)
 * </pre>
 * The type on the <tt>varargParameter</tt> node should be <tt>String</tt> in the above case (and <i>not</i>
 * <tt>String[]</tt>).  Also observe that methods with no body, such as the abstract method
 * <pre>public abstract void foo();</pre>
 * will have a <tt>null</tt> body.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MethodDeclarationNode extends Node, ClassMemberNode,  InterfaceMemberNode,  AnonymousClassMemberNode
{
    /**
     * Gets the body of this method.
     * @return The body of this method.
     */
    public BlockNode getBody();

    /**
     * Changes the body of this method.
     * @param body The body of this method.
     */
    public void setBody(BlockNode body);

    /**
     * Gets the modifiers for this method.
     * @return The modifiers for this method.
     */
    public MethodModifiersNode getModifiers();

    /**
     * Changes the modifiers for this method.
     * @param modifiers The modifiers for this method.
     */
    public void setModifiers(MethodModifiersNode modifiers);

    /**
     * Gets this method's name.
     * @return This method's name.
     */
    public IdentifierNode getIdentifier();

    /**
     * Changes this method's name.
     * @param identifier This method's name.
     */
    public void setIdentifier(IdentifierNode identifier);

    /**
     * Gets the parameters declared by this method.
     * @return The parameters declared by this method.
     */
    public ListNode<VariableNode> getParameters();

    /**
     * Changes the parameters declared by this method.
     * @param parameters The parameters declared by this method.
     */
    public void setParameters(ListNode<VariableNode> parameters);

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
    public ListNode<UnparameterizedTypeNode> getThrowTypes();

    /**
     * Changes the types of exceptions thrown by this method.
     * @param throwTypes The types of exceptions thrown by this method.
     */
    public void setThrowTypes(ListNode<UnparameterizedTypeNode> throwTypes);

    /**
     * Gets this method's applicable type parameters.
     * @return This method's applicable type parameters.
     */
    public ListNode<TypeParameterNode> getTypeParameters();

    /**
     * Changes this method's applicable type parameters.
     * @param typeParameters This method's applicable type parameters.
     */
    public void setTypeParameters(ListNode<TypeParameterNode> typeParameters);

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
