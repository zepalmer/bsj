package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing a return statement, as in;
 * <pre>return <i>expr</i>;</pre>
 * or
 * <pre>return;</pre>
 * For void return statements, the <tt>expression</tt> is <tt>null</tt>.
 */
public interface ReturnNode extends Node, StatementNode
{
    /**
     * Gets the expression to return.
     * @return The expression to return.
     */
    public ExpressionNode getExpression();

    /**
     * Changes the expression to return.
     * @param expression The expression to return.
     */
    public void setExpression(ExpressionNode expression);

}
