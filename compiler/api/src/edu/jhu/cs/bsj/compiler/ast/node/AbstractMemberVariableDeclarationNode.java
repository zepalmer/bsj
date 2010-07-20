package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListNode;

/**
 * A node representing a member variable declaration.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AbstractMemberVariableDeclarationNode<T extends ModifiersNode> extends Node, VariableDeclaratorOwnerNode
{
    /**
     * Gets the modifiers for this declaration.
     * @return The modifiers for this declaration.
     */
    public T getModifiers();
    
    /**
     * Changes the modifiers for this declaration.
     * @param modifiers The modifiers for this declaration.
     */
    public void setModifiers(T modifiers);
    
    /**
     * Gets the type of the declared variables.
     * @return The type of the declared variables.
     */
    public TypeNode getType();
    
    /**
     * Changes the type of the declared variables.
     * @param type The type of the declared variables.
     */
    public void setType(TypeNode type);
    
    /**
     * Gets the variable declarators for this node.
     * @return The variable declarators for this node.
     */
    public VariableDeclaratorListNode getDeclarators();
    
    /**
     * Changes the variable declarators for this node.
     * @param declarators The variable declarators for this node.
     */
    public void setDeclarators(VariableDeclaratorListNode declarators);
    
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
    public AbstractMemberVariableDeclarationNode<T> deepCopy(BsjNodeFactory factory);
}
