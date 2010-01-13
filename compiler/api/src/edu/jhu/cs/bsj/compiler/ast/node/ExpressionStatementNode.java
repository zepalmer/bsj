package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing an expression statement.  This allows any expression to be used as a statement and its
 * value discarded.
 */
public interface ExpressionStatementNode extends Node, StatementNode
{
    /**
     * Gets this statement's expression.
     * @return This statement's expression.
     */
    public ExpressionNode getExpression();

    /**
     * Changes this statement's expression.
     * @param expression This statement's expression.
     */
    public void setExpression(ExpressionNode expression);

}
