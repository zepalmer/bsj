package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;

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
 * <tt>String[]</tt>).
 * <p/>
 * Observe that methods with no body, such as the abstract method
 * <pre>public abstract void foo();</pre>
 * will have a <tt>null</tt> body.  Also, methods which are representative of those declarations found in
 * binaries will have a <tt>null</tt> body.  This is an exception to the usual rule that lists are non-null
 * in the AST API.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MethodDeclarationNode extends Node, InterfaceMemberNode, AnonymousClassMemberNode, AbstractInvokableDeclarationNode<MethodModifiersNode>, InvokableNameBindingNode
{
    /**
     * Gets the body of this method.
     * @return The body of this method.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public BlockStatementListNode getBody() throws ClassCastException;
    
    /**
     * Gets the union object for the body of this method.
     * @return A union object representing The body of this method.
     */
    public NodeUnion<? extends BlockStatementListNode> getUnionForBody();
    
    /**
     * Changes the body of this method.
     * @param body The body of this method.
     */
    public void setBody(BlockStatementListNode body);
    
    /**
     * Changes the body of this method.
     * @param body The body of this method.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForBody(NodeUnion<? extends BlockStatementListNode> body) throws NullPointerException;
    
    /**
     * Gets the modifiers for this method.
     * @return The modifiers for this method.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public MethodModifiersNode getModifiers() throws ClassCastException;
    
    /**
     * Gets the union object for the modifiers for this method.
     * @return A union object representing The modifiers for this method.
     */
    public NodeUnion<? extends MethodModifiersNode> getUnionForModifiers();
    
    /**
     * Changes the modifiers for this method.
     * @param modifiers The modifiers for this method.
     */
    public void setModifiers(MethodModifiersNode modifiers);
    
    /**
     * Changes the modifiers for this method.
     * @param modifiers The modifiers for this method.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForModifiers(NodeUnion<? extends MethodModifiersNode> modifiers) throws NullPointerException;
    
    /**
     * Gets this method's name.
     * @return This method's name.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getIdentifier() throws ClassCastException;
    
    /**
     * Gets the union object for this method's name.
     * @return A union object representing This method's name.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier();
    
    /**
     * Changes this method's name.
     * @param identifier This method's name.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Changes this method's name.
     * @param identifier This method's name.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier) throws NullPointerException;
    
    /**
     * Gets the parameters declared by this method.
     * @return The parameters declared by this method.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public VariableListNode getParameters() throws ClassCastException;
    
    /**
     * Gets the union object for the parameters declared by this method.
     * @return A union object representing The parameters declared by this method.
     */
    public NodeUnion<? extends VariableListNode> getUnionForParameters();
    
    /**
     * Changes the parameters declared by this method.
     * @param parameters The parameters declared by this method.
     */
    public void setParameters(VariableListNode parameters);
    
    /**
     * Changes the parameters declared by this method.
     * @param parameters The parameters declared by this method.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForParameters(NodeUnion<? extends VariableListNode> parameters) throws NullPointerException;
    
    /**
     * Gets the vararg parameter declared by this method.
     * @return The vararg parameter declared by this method.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public VariableNode getVarargParameter() throws ClassCastException;
    
    /**
     * Gets the union object for the vararg parameter declared by this method.
     * @return A union object representing The vararg parameter declared by this method.
     */
    public NodeUnion<? extends VariableNode> getUnionForVarargParameter();
    
    /**
     * Changes the vararg parameter declared by this method.
     * @param varargParameter The vararg parameter declared by this method.
     */
    public void setVarargParameter(VariableNode varargParameter);
    
    /**
     * Changes the vararg parameter declared by this method.
     * @param varargParameter The vararg parameter declared by this method.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForVarargParameter(NodeUnion<? extends VariableNode> varargParameter) throws NullPointerException;
    
    /**
     * Gets the type of value returned.
     * @return The type of value returned.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeNode getReturnType() throws ClassCastException;
    
    /**
     * Gets the union object for the type of value returned.
     * @return A union object representing The type of value returned.
     */
    public NodeUnion<? extends TypeNode> getUnionForReturnType();
    
    /**
     * Changes the type of value returned.
     * @param returnType The type of value returned.
     */
    public void setReturnType(TypeNode returnType);
    
    /**
     * Changes the type of value returned.
     * @param returnType The type of value returned.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForReturnType(NodeUnion<? extends TypeNode> returnType) throws NullPointerException;
    
    /**
     * Gets the types of exceptions thrown by this method.
     * @return The types of exceptions thrown by this method.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public UnparameterizedTypeListNode getThrowTypes() throws ClassCastException;
    
    /**
     * Gets the union object for the types of exceptions thrown by this method.
     * @return A union object representing The types of exceptions thrown by this method.
     */
    public NodeUnion<? extends UnparameterizedTypeListNode> getUnionForThrowTypes();
    
    /**
     * Changes the types of exceptions thrown by this method.
     * @param throwTypes The types of exceptions thrown by this method.
     */
    public void setThrowTypes(UnparameterizedTypeListNode throwTypes);
    
    /**
     * Changes the types of exceptions thrown by this method.
     * @param throwTypes The types of exceptions thrown by this method.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForThrowTypes(NodeUnion<? extends UnparameterizedTypeListNode> throwTypes) throws NullPointerException;
    
    /**
     * Gets this method's applicable type parameters.
     * @return This method's applicable type parameters.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeParameterListNode getTypeParameters() throws ClassCastException;
    
    /**
     * Gets the union object for this method's applicable type parameters.
     * @return A union object representing This method's applicable type parameters.
     */
    public NodeUnion<? extends TypeParameterListNode> getUnionForTypeParameters();
    
    /**
     * Changes this method's applicable type parameters.
     * @param typeParameters This method's applicable type parameters.
     */
    public void setTypeParameters(TypeParameterListNode typeParameters);
    
    /**
     * Changes this method's applicable type parameters.
     * @param typeParameters This method's applicable type parameters.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForTypeParameters(NodeUnion<? extends TypeParameterListNode> typeParameters) throws NullPointerException;
    
    /**
     * Gets the associated javadoc comment for this node.
     * @return The associated javadoc comment for this node.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public JavadocNode getJavadoc() throws ClassCastException;
    
    /**
     * Gets the union object for the associated javadoc comment for this node.
     * @return A union object representing The associated javadoc comment for this node.
     */
    public NodeUnion<? extends JavadocNode> getUnionForJavadoc();
    
    /**
     * Changes the associated javadoc comment for this node.
     * @param javadoc The associated javadoc comment for this node.
     */
    public void setJavadoc(JavadocNode javadoc);
    
    /**
     * Changes the associated javadoc comment for this node.
     * @param javadoc The associated javadoc comment for this node.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForJavadoc(NodeUnion<? extends JavadocNode> javadoc) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MethodDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
