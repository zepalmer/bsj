package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for an expression statement.
 */
public interface ExpressionStatementNode extends StatementNode
{
    ExpressionNode getExpression();
}
