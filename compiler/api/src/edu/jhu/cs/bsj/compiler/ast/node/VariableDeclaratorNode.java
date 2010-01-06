package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents a declarator for a variable declaration.  For example, in
 * <pre>int x = 5, y;</pre>
 * this node either represents
 * <pre>x = 5</pre>
 * or
 * <pre>y</pre>
 * .  Note that variable multi-declaration syntax allows different types, as in
 * <pre>int x = 5, y[] = new int[2];</pre>
 * Hence, type exists on this node instead of its parent.  If the variable is not initialized, the
 * <tt>initializer</tt> field is <tt>null</tt>.
 */
public interface VariableDeclaratorNode extends StatementNode
{
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
