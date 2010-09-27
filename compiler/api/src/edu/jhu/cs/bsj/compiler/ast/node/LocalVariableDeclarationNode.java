package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListNode;

/**
 * A node for the declaration of a variable, as in:
 *     <pre>
 *     <i>type identifier</i>;
 *     </pre>
 * or
 *     <pre>
 *     <i>type identifier</i> = <i>expression</i>;
 *     </pre>
 * or
 *     <pre>
 *     <i>type identifier</i> = <i>expression</i>, <i>identifier</i> = <i>expression</i>, ...;
 *     </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface LocalVariableDeclarationNode extends Node, BlockStatementNode, VariableDeclaratorOwnerNode, DeclarationNode, ModifiedNode<VariableModifiersNode>
{
    /**
     * Gets the modifiers for this variable.
     * @return The modifiers for this variable.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public VariableModifiersNode getModifiers() throws ClassCastException;
    
    /**
     * Gets the union object for the modifiers for this variable.
     * @return A union object representing The modifiers for this variable.
     */
    public NodeUnion<? extends VariableModifiersNode> getUnionForModifiers();
    
    /**
     * Changes the modifiers for this variable.
     * @param modifiers The modifiers for this variable.
     */
    public void setModifiers(VariableModifiersNode modifiers);
    
    /**
     * Changes the modifiers for this variable.
     * @param modifiers The modifiers for this variable.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForModifiers(NodeUnion<? extends VariableModifiersNode> modifiers) throws NullPointerException;
    
    /**
     * Gets the type of the declared variables.
     * @return The type of the declared variables.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeNode getType() throws ClassCastException;
    
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
    public VariableDeclaratorListNode getDeclarators() throws ClassCastException;
    
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
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public LocalVariableDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
