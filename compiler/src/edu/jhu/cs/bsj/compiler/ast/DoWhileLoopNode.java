package edu.jhu.cs.bsj.compiler;

public interface DoWhileLoopNode extends StatementNode
{
    ExpressionNode getCondition();
    
    StatementNode getStatement();
}
