package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node describing a variable, as in:
 *     <pre>
 *     <i>type identifier</i>
 *     </pre>        
 */
public interface VariableNode extends Node
{
    /**
     * Gets the modifiers of this parameter.
     * @return The modifiers of this parameter.
     */
    public ModifiersNode getModifiers();

    /**
     * Changes the modifiers of this parameter.
     * @param modifiers The modifiers of this parameter.
     */
    public void setModifiers(ModifiersNode modifiers);

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

}
