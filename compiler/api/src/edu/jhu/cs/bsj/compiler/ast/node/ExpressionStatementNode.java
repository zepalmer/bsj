package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A node representing an expression statement.  This allows any expression to be used as a statement and its
 * value discarded.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
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
