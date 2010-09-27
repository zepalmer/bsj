package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * A node describing a variable, as in:
 *     <pre>
 *     <i>type identifier</i>
 *     </pre>        
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface VariableNode extends Node, VariableNameBindingNode, ModifiedNode<VariableModifiersNode>
{
    /**
     * Gets the modifiers of this parameter.
     * @return The modifiers of this parameter.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public VariableModifiersNode getModifiers() throws ClassCastException;
    
    /**
     * Gets the union object for the modifiers of this parameter.
     * @return A union object representing The modifiers of this parameter.
     */
    public NodeUnion<? extends VariableModifiersNode> getUnionForModifiers();
    
    /**
     * Changes the modifiers of this parameter.
     * @param modifiers The modifiers of this parameter.
     */
    public void setModifiers(VariableModifiersNode modifiers);
    
    /**
     * Changes the modifiers of this parameter.
     * @param modifiers The modifiers of this parameter.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForModifiers(NodeUnion<? extends VariableModifiersNode> modifiers) throws NullPointerException;
    
    /**
     * Gets the type of the variable.
     * @return The type of the variable.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeNode getType() throws ClassCastException;
    
    /**
     * Gets the union object for the type of the variable.
     * @return A union object representing The type of the variable.
     */
    public NodeUnion<? extends TypeNode> getUnionForType();
    
    /**
     * Changes the type of the variable.
     * @param type The type of the variable.
     */
    public void setType(TypeNode type);
    
    /**
     * Changes the type of the variable.
     * @param type The type of the variable.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForType(NodeUnion<? extends TypeNode> type) throws NullPointerException;
    
    /**
     * Gets the name of the variable.
     * @return The name of the variable.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getIdentifier() throws ClassCastException;
    
    /**
     * Gets the union object for the name of the variable.
     * @return A union object representing The name of the variable.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier();
    
    /**
     * Changes the name of the variable.
     * @param identifier The name of the variable.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Changes the name of the variable.
     * @param identifier The name of the variable.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public VariableNode deepCopy(BsjNodeFactory factory);
    
}
