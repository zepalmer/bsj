package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
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
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ConstructorDeclarationNode extends Node, AbstractInvokableDeclarationNode
{
    /**
     * Gets the identifier for the name of this constructor.
     * @return The identifier for the name of this constructor.
     */
    public IdentifierNode getIdentifier();
    
    /**
     * Changes the identifier for the name of this constructor.
     * @param identifier The identifier for the name of this constructor.
     */
    public void setIdentifier(IdentifierNode identifier);
    
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
    public ConstructorModifiersNode getModifiers();
    
    /**
     * Changes the modifiers for this constructor.
     * @param modifiers The modifiers for this constructor.
     */
    public void setModifiers(ConstructorModifiersNode modifiers);
    
    /**
     * Gets the parameters declared by this constructor.
     * @return The parameters declared by this constructor.
     */
    public VariableListNode getParameters();
    
    /**
     * Changes the parameters declared by this constructor.
     * @param parameters The parameters declared by this constructor.
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
     * Gets the types of exceptions thrown by this constructor.
     * @return The types of exceptions thrown by this constructor.
     */
    public UnparameterizedTypeListNode getThrowTypes();
    
    /**
     * Changes the types of exceptions thrown by this constructor.
     * @param throwTypes The types of exceptions thrown by this constructor.
     */
    public void setThrowTypes(UnparameterizedTypeListNode throwTypes);
    
    /**
     * Gets this constructor's applicable type parameters.
     * @return This constructor's applicable type parameters.
     */
    public TypeParameterListNode getTypeParameters();
    
    /**
     * Changes this constructor's applicable type parameters.
     * @param typeParameters This constructor's applicable type parameters.
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
    public ConstructorDeclarationNode deepCopy(BsjNodeFactory factory);
}
