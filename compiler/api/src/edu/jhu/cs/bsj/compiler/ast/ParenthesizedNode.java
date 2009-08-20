package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for a parenthesized expression.
 */
public interface ParenthesizedNode extends ExpressionNode
{
    ExpressionNode getExpression();
}
