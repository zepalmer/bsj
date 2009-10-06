package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node for the declaration of a variable, as in:
 *     <pre>
 *     <i>type identifier</i>;
 *     </pre>
 * or
 *     <pre>
 *     <i>type identifier</i> = <i>expression</i>;
 *     </pre>
 */
public interface VariableDeclarationNode extends StatementNode
{
    /**
     * Gets the modifiers for this variable.
     * @return The modifiers for this variable.
     */
    public ModifiersNode getModifiers();

    /**
     * Changes the modifiers for this variable.
     * @param modifiers The modifiers for this variable.
     */
    public void setModifiers(ModifiersNode modifiers);

    /**
     * Gets the type of this variable.
     * @return The type of this variable.
     */
    public TypeNode getType();

    /**
     * Changes the type of this variable.
     * @param type The type of this variable.
     */
    public void setType(TypeNode type);

    /**
     * Gets the name of this variable.
     * @return The name of this variable.
     */
    public IdentifierNode getName();

    /**
     * Changes the name of this variable.
     * @param name The name of this variable.
     */
    public void setName(IdentifierNode name);

    /**
     * Gets the initializer to use.
     * @return The initializer to use.
     */
    public ExpressionNode getInitializer();

    /**
     * Changes the initializer to use.
     * @param initializer The initializer to use.
     */
    public void setInitializer(ExpressionNode initializer);

}
