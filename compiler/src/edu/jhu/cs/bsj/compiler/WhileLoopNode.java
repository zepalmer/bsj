package edu.jhu.cs.bsj.compiler;

public interface WhileLoopNode extends StatementNode
{
    ExpressionNode getCondition();
    
    StatementNode getStatement();
}
