package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for unary expressions.
 */
public interface UnaryNode extends ExpressionNode
{
    ExpressionNode getExpression();
}
