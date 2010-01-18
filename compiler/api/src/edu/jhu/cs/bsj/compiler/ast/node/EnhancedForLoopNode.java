package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A node representing a for-each loop, as in:
 * <pre>
 * for (<i>variable</i> : <i>expression</i>)
 *     <i>body</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface EnhancedForLoopNode extends Node, StatementNode
{
    /**
     * Gets the iterator variable.
     * @return The iterator variable.
     */
    public VariableNode getVariable();

    /**
     * Changes the iterator variable.
     * @param variable The iterator variable.
     */
    public void setVariable(VariableNode variable);

    /**
     * Gets the loop's iterable expression.
     * @return The loop's iterable expression.
     */
    public ExpressionNode getExpression();

    /**
     * Changes the loop's iterable expression.
     * @param expression The loop's iterable expression.
     */
    public void setExpression(ExpressionNode expression);

    /**
     * Gets the loop's statement.
     * @return The loop's statement.
     */
    public StatementNode getStatement();

    /**
     * Changes the loop's statement.
     * @param statement The loop's statement.
     */
    public void setStatement(StatementNode statement);

}
