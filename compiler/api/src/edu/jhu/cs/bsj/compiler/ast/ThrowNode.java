package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for throwing exceptions.
 */
public interface ThrowNode extends StatementNode
{
    ExpressionNode getExpression();
}
