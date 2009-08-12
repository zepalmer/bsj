package edu.jhu.cs.bsj.compiler.ast;

public interface ParenthesizedNode extends ExpressionNode
{
    ExpressionNode getExpression();
}
