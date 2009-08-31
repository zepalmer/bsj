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
     * Gets the variable to declare.
     * @return The variable to declare.
     */
    public VariableNode getVariable();

    /**
     * Changes the variable to declare.
     * @param variable The variable to declare.
     */
    public void setVariable(VariableNode variable);

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
