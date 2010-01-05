package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents an assert statement, as in
 * <pre>
 *     assert <i>expr</i>;
 * </pre>
 * or
 * <pre>
 *     assert <i>expr</i> : <i>expr</i>;
 * </pre>
 */
public interface AssertStatementNode extends StatementNode
{
    /**
     * Gets the assertion's test expression.
     * @return The assertion's test expression.
     */
    public ExpressionNode getTestExpression();

    /**
     * Changes the assertion's test expression.
     * @param testExpression The assertion's test expression.
     */
    public void setTestExpression(ExpressionNode testExpression);

    /**
     * Gets the assertion's message expression.
     * @return The assertion's message expression.
     */
    public ExpressionNode getMessageExpression();

    /**
     * Changes the assertion's message expression.
     * @param messageExpression The assertion's message expression.
     */
    public void setMessageExpression(ExpressionNode messageExpression);

}
