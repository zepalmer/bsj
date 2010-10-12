package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListNode;

/**
 * A node representing a member variable declaration.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AbstractMemberVariableDeclarationNode<T extends ModifiersNode> extends Node, VariableDeclaratorOwnerNode, DeclarationNode
{
    /**
     * Gets the modifiers for this declaration.
     * @return The modifiers for this declaration.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public T getModifiers()throws ClassCastException;
    
    /**
     * Gets the union object for the modifiers for this declaration.
     * @return A union object representing The modifiers for this declaration.
     */
    public NodeUnion<? extends T> getUnionForModifiers();
    
    /**
     * Changes the modifiers for this declaration.
     * @param modifiers The modifiers for this declaration.
     */
    public void setModifiers(T modifiers);
    
    /**
     * Changes the modifiers for this declaration.
     * @param modifiers The modifiers for this declaration.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForModifiers(NodeUnion<? extends T> modifiers) throws NullPointerException;
    
    /**
     * Gets the type of the declared variables.
     * @return The type of the declared variables.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeNode getType()throws ClassCastException;
    
    /**
     * Gets the union object for the type of the declared variables.
     * @return A union object representing The type of the declared variables.
     */
    public NodeUnion<? extends TypeNode> getUnionForType();
    
    /**
     * Changes the type of the declared variables.
     * @param type The type of the declared variables.
     */
    public void setType(TypeNode type);
    
    /**
     * Changes the type of the declared variables.
     * @param type The type of the declared variables.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForType(NodeUnion<? extends TypeNode> type) throws NullPointerException;
    
    /**
     * Gets the variable declarators for this node.
     * @return The variable declarators for this node.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public VariableDeclaratorListNode getDeclarators()throws ClassCastException;
    
    /**
     * Gets the union object for the variable declarators for this node.
     * @return A union object representing The variable declarators for this node.
     */
    public NodeUnion<? extends VariableDeclaratorListNode> getUnionForDeclarators();
    
    /**
     * Changes the variable declarators for this node.
     * @param declarators The variable declarators for this node.
     */
    public void setDeclarators(VariableDeclaratorListNode declarators);
    
    /**
     * Changes the variable declarators for this node.
     * @param declarators The variable declarators for this node.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForDeclarators(NodeUnion<? extends VariableDeclaratorListNode> declarators) throws NullPointerException;
    
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
    public AbstractMemberVariableDeclarationNode<T> deepCopy(BsjNodeFactory factory);
    
}
