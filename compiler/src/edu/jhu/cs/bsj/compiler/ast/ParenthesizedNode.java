package edu.jhu.cs.bsj.compiler;

public interface ParenthesizedNode extends ExpressionNode
{
    ExpressionNode getExpression();
}
