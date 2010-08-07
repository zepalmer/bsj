package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node describing a variable, as in:
 *     <pre>
 *     <i>type identifier</i>
 *     </pre>        
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface VariableNode extends Node, ModifiedNode<VariableModifiersNode>
{
    /**
     * Gets the modifiers of this parameter.
     * @return The modifiers of this parameter.
     */
    public VariableModifiersNode getModifiers();
    
    /**
     * Changes the modifiers of this parameter.
     * @param modifiers The modifiers of this parameter.
     */
    public void setModifiers(VariableModifiersNode modifiers);
    
    /**
     * Gets the type of the variable.
     * @return The type of the variable.
     */
    public TypeNode getType();
    
    /**
     * Changes the type of the variable.
     * @param type The type of the variable.
     */
    public void setType(TypeNode type);
    
    /**
     * Gets the name of the variable.
     * @return The name of the variable.
     */
    public IdentifierNode getIdentifier();
    
    /**
     * Changes the name of the variable.
     * @param identifier The name of the variable.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public VariableNode deepCopy(BsjNodeFactory factory);
}
