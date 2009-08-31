package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing a do-while loop, as in:
 * <pre>
 * do <i>body</i> while (<i>condition</i>);
 * </pre>
 */
public interface DoWhileLoopNode extends StatementNode
{
    /**
     * Gets the loop's condition.
     * @return The loop's condition.
     */
    public ExpressionNode getCondition();

    /**
     * Changes the loop's condition.
     * @param condition The loop's condition.
     */
    public void setCondition(ExpressionNode condition);

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
