package edu.jhu.cs.bsj.compiler.ast;

public interface DoWhileLoopNode extends StatementNode
{
    ExpressionNode getCondition();
    
    StatementNode getStatement();
}
