package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;

/**
 * A node representing an executable declaration, such as a method or a constructor.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AbstractInvokableDeclarationNode extends Node, ClassMemberNode, DeclarationNode
{
    /**
     * Gets the identifier for the name of this executable.
     * @return The identifier for the name of this executable.
     */
    public IdentifierNode getIdentifier();
    
    /**
     * Changes the identifier for the name of this executable.
     * @param identifier The identifier for the name of this executable.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Gets the modifiers for this executable.
     * @return The modifiers for this executable.
     */
    public ModifiersNode getModifiers();
    
    /**
     * Gets the parameters declared by this executable.
     * @return The parameters declared by this executable.
     */
    public VariableListNode getParameters();
    
    /**
     * Changes the parameters declared by this executable.
     * @param parameters The parameters declared by this executable.
     */
    public void setParameters(VariableListNode parameters);
    
    /**
     * Gets the vararg parameter declared by this executable.
     * @return The vararg parameter declared by this executable.
     */
    public VariableNode getVarargParameter();
    
    /**
     * Changes the vararg parameter declared by this executable.
     * @param varargParameter The vararg parameter declared by this executable.
     */
    public void setVarargParameter(VariableNode varargParameter);
    
    /**
     * Gets the types of exceptions thrown by this executable.
     * @return The types of exceptions thrown by this executable.
     */
    public UnparameterizedTypeListNode getThrowTypes();
    
    /**
     * Changes the types of exceptions thrown by this executable.
     * @param throwTypes The types of exceptions thrown by this executable.
     */
    public void setThrowTypes(UnparameterizedTypeListNode throwTypes);
    
    /**
     * Gets this executable's applicable type parameters.
     * @return This executable's applicable type parameters.
     */
    public TypeParameterListNode getTypeParameters();
    
    /**
     * Changes this executable's applicable type parameters.
     * @param typeParameters This executable's applicable type parameters.
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
    public AbstractInvokableDeclarationNode deepCopy(BsjNodeFactory factory);
}
