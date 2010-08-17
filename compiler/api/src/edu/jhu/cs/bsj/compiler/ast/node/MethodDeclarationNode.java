package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
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
     */
    public BlockStatementListNode getBody();
    
    /**
     * Changes the body of this method.
     * @param body The body of this method.
     */
    public void setBody(BlockStatementListNode body);
    
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
    public VariableListNode getParameters();
    
    /**
     * Changes the parameters declared by this method.
     * @param parameters The parameters declared by this method.
     */
    public void setParameters(VariableListNode parameters);
    
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
    public UnparameterizedTypeListNode getThrowTypes();
    
    /**
     * Changes the types of exceptions thrown by this method.
     * @param throwTypes The types of exceptions thrown by this method.
     */
    public void setThrowTypes(UnparameterizedTypeListNode throwTypes);
    
    /**
     * Gets this method's applicable type parameters.
     * @return This method's applicable type parameters.
     */
    public TypeParameterListNode getTypeParameters();
    
    /**
     * Changes this method's applicable type parameters.
     * @param typeParameters This method's applicable type parameters.
     */
    public void setTypeParameters(TypeParameterListNode typeParameters);
    
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
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MethodDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
