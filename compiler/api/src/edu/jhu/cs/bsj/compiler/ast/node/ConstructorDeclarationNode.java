package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;

/**
 * A node representing a constructor declaration, as in:
 * <pre>
 *     <i>modifiers typeParams typeName</i>(<i>parameter...</i>) throws <i>expr...</i>
 *         <i>body</i>
 * </pre>
 * See {@link MethodDeclarationNode} for more information.
 * <p/>
 * Constructors representative of those found in binary class files will have a <tt>null</tt> body.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ConstructorDeclarationNode extends Node, AbstractInvokableDeclarationNode<ConstructorModifiersNode>
{
    /**
     * Gets the identifier for the name of this constructor.
     * @return The identifier for the name of this constructor.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getIdentifier()throws ClassCastException;
    
    /**
     * Gets the union object for the identifier for the name of this constructor.
     * @return A union object representing The identifier for the name of this constructor.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier();
    
    /**
     * Changes the identifier for the name of this constructor.
     * @param identifier The identifier for the name of this constructor.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Changes the identifier for the name of this constructor.
     * @param identifier The identifier for the name of this constructor.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier) throws NullPointerException;
    
    /**
     * Gets the body of this constructor.
     * @return The body of this constructor.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ConstructorBodyNode getBody()throws ClassCastException;
    
    /**
     * Gets the union object for the body of this constructor.
     * @return A union object representing The body of this constructor.
     */
    public NodeUnion<? extends ConstructorBodyNode> getUnionForBody();
    
    /**
     * Changes the body of this constructor.
     * @param body The body of this constructor.
     */
    public void setBody(ConstructorBodyNode body);
    
    /**
     * Changes the body of this constructor.
     * @param body The body of this constructor.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForBody(NodeUnion<? extends ConstructorBodyNode> body) throws NullPointerException;
    
    /**
     * Gets the modifiers for this constructor.
     * @return The modifiers for this constructor.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ConstructorModifiersNode getModifiers()throws ClassCastException;
    
    /**
     * Gets the union object for the modifiers for this constructor.
     * @return A union object representing The modifiers for this constructor.
     */
    public NodeUnion<? extends ConstructorModifiersNode> getUnionForModifiers();
    
    /**
     * Changes the modifiers for this constructor.
     * @param modifiers The modifiers for this constructor.
     */
    public void setModifiers(ConstructorModifiersNode modifiers);
    
    /**
     * Changes the modifiers for this constructor.
     * @param modifiers The modifiers for this constructor.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForModifiers(NodeUnion<? extends ConstructorModifiersNode> modifiers) throws NullPointerException;
    
    /**
     * Gets the parameters declared by this constructor.
     * @return The parameters declared by this constructor.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public VariableListNode getParameters()throws ClassCastException;
    
    /**
     * Gets the union object for the parameters declared by this constructor.
     * @return A union object representing The parameters declared by this constructor.
     */
    public NodeUnion<? extends VariableListNode> getUnionForParameters();
    
    /**
     * Changes the parameters declared by this constructor.
     * @param parameters The parameters declared by this constructor.
     */
    public void setParameters(VariableListNode parameters);
    
    /**
     * Changes the parameters declared by this constructor.
     * @param parameters The parameters declared by this constructor.
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
    public VariableNode getVarargParameter()throws ClassCastException;
    
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
     * Gets the types of exceptions thrown by this constructor.
     * @return The types of exceptions thrown by this constructor.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public UnparameterizedTypeListNode getThrowTypes()throws ClassCastException;
    
    /**
     * Gets the union object for the types of exceptions thrown by this constructor.
     * @return A union object representing The types of exceptions thrown by this constructor.
     */
    public NodeUnion<? extends UnparameterizedTypeListNode> getUnionForThrowTypes();
    
    /**
     * Changes the types of exceptions thrown by this constructor.
     * @param throwTypes The types of exceptions thrown by this constructor.
     */
    public void setThrowTypes(UnparameterizedTypeListNode throwTypes);
    
    /**
     * Changes the types of exceptions thrown by this constructor.
     * @param throwTypes The types of exceptions thrown by this constructor.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForThrowTypes(NodeUnion<? extends UnparameterizedTypeListNode> throwTypes) throws NullPointerException;
    
    /**
     * Gets this constructor's applicable type parameters.
     * @return This constructor's applicable type parameters.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeParameterListNode getTypeParameters()throws ClassCastException;
    
    /**
     * Gets the union object for this constructor's applicable type parameters.
     * @return A union object representing This constructor's applicable type parameters.
     */
    public NodeUnion<? extends TypeParameterListNode> getUnionForTypeParameters();
    
    /**
     * Changes this constructor's applicable type parameters.
     * @param typeParameters This constructor's applicable type parameters.
     */
    public void setTypeParameters(TypeParameterListNode typeParameters);
    
    /**
     * Changes this constructor's applicable type parameters.
     * @param typeParameters This constructor's applicable type parameters.
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
    public JavadocNode getJavadoc()throws ClassCastException;
    
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
    public ConstructorDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
