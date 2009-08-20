package edu.jhu.cs.bsj.compiler.ast;

public interface ThrowNode extends StatementNode
{
    ExpressionNode getExpression();
}
