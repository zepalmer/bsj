package edu.jhu.cs.bsj.compiler.ast;

public interface WhileLoopNode extends StatementNode
{
    ExpressionNode getCondition();
    
    StatementNode getStatement();
}
