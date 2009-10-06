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
     * Gets the type of the parameter.
     * @return The type of the parameter.
     */
    public TypeNode getType();

    /**
     * Changes the type of the parameter.
     * @param type The type of the parameter.
     */
    public void setType(TypeNode type);

    /**
     * Gets the name of the parameter.
     * @return The name of the parameter.
     */
    public IdentifierNode getName();

    /**
     * Changes the name of the parameter.
     * @param name The name of the parameter.
     */
    public void setName(IdentifierNode name);

}
