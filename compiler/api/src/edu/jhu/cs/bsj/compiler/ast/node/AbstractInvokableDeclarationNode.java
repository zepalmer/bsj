package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;

/**
 * A node representing an executable declaration, such as a method or a constructor.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AbstractInvokableDeclarationNode<T extends ModifiersNode> extends Node, ClassMemberNode, DeclarationNode, ModifiedNode<T>
{
    /**
     * Gets the identifier for the name of this executable.
     * @return The identifier for the name of this executable.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getIdentifier() throws ClassCastException;
    
    /**
     * Gets the union object for the identifier for the name of this executable.
     * @return A union object representing The identifier for the name of this executable.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier();
    
    /**
     * Changes the identifier for the name of this executable.
     * @param identifier The identifier for the name of this executable.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Changes the identifier for the name of this executable.
     * @param identifier The identifier for the name of this executable.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier) throws NullPointerException;
    
    /**
     * Gets the modifiers for this executable.
     * @return The modifiers for this executable.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public T getModifiers() throws ClassCastException;
    
    /**
     * Gets the union object for the modifiers for this executable.
     * @return A union object representing The modifiers for this executable.
     */
    public NodeUnion<? extends T> getUnionForModifiers();
    
    /**
     * Changes the modifiers for this executable.
     * @param modifiers The modifiers for this executable.
     */
    public void setModifiers(T modifiers);
    
    /**
     * Changes the modifiers for this executable.
     * @param modifiers The modifiers for this executable.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForModifiers(NodeUnion<? extends T> modifiers) throws NullPointerException;
    
    /**
     * Gets the parameters declared by this executable.
     * @return The parameters declared by this executable.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public VariableListNode getParameters() throws ClassCastException;
    
    /**
     * Gets the union object for the parameters declared by this executable.
     * @return A union object representing The parameters declared by this executable.
     */
    public NodeUnion<? extends VariableListNode> getUnionForParameters();
    
    /**
     * Changes the parameters declared by this executable.
     * @param parameters The parameters declared by this executable.
     */
    public void setParameters(VariableListNode parameters);
    
    /**
     * Changes the parameters declared by this executable.
     * @param parameters The parameters declared by this executable.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForParameters(NodeUnion<? extends VariableListNode> parameters) throws NullPointerException;
    
    /**
     * Gets the vararg parameter declared by this executable.
     * @return The vararg parameter declared by this executable.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public VariableNode getVarargParameter() throws ClassCastException;
    
    /**
     * Gets the union object for the vararg parameter declared by this executable.
     * @return A union object representing The vararg parameter declared by this executable.
     */
    public NodeUnion<? extends VariableNode> getUnionForVarargParameter();
    
    /**
     * Changes the vararg parameter declared by this executable.
     * @param varargParameter The vararg parameter declared by this executable.
     */
    public void setVarargParameter(VariableNode varargParameter);
    
    /**
     * Changes the vararg parameter declared by this executable.
     * @param varargParameter The vararg parameter declared by this executable.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForVarargParameter(NodeUnion<? extends VariableNode> varargParameter) throws NullPointerException;
    
    /**
     * Gets the types of exceptions thrown by this executable.
     * @return The types of exceptions thrown by this executable.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public UnparameterizedTypeListNode getThrowTypes() throws ClassCastException;
    
    /**
     * Gets the union object for the types of exceptions thrown by this executable.
     * @return A union object representing The types of exceptions thrown by this executable.
     */
    public NodeUnion<? extends UnparameterizedTypeListNode> getUnionForThrowTypes();
    
    /**
     * Changes the types of exceptions thrown by this executable.
     * @param throwTypes The types of exceptions thrown by this executable.
     */
    public void setThrowTypes(UnparameterizedTypeListNode throwTypes);
    
    /**
     * Changes the types of exceptions thrown by this executable.
     * @param throwTypes The types of exceptions thrown by this executable.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForThrowTypes(NodeUnion<? extends UnparameterizedTypeListNode> throwTypes) throws NullPointerException;
    
    /**
     * Gets this executable's applicable type parameters.
     * @return This executable's applicable type parameters.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeParameterListNode getTypeParameters() throws ClassCastException;
    
    /**
     * Gets the union object for this executable's applicable type parameters.
     * @return A union object representing This executable's applicable type parameters.
     */
    public NodeUnion<? extends TypeParameterListNode> getUnionForTypeParameters();
    
    /**
     * Changes this executable's applicable type parameters.
     * @param typeParameters This executable's applicable type parameters.
     */
    public void setTypeParameters(TypeParameterListNode typeParameters);
    
    /**
     * Changes this executable's applicable type parameters.
     * @param typeParameters This executable's applicable type parameters.
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
    public AbstractInvokableDeclarationNode<T> deepCopy(BsjNodeFactory factory);
    
}
