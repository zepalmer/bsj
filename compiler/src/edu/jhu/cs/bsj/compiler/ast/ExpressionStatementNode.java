package edu.jhu.cs.bsj.compiler.ast;

public interface ExpressionStatementNode extends StatementNode
{
    ExpressionNode getExpression();
}
