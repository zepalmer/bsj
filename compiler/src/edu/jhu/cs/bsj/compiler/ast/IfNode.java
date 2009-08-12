package edu.jhu.cs.bsj.compiler;

public interface IfNode extends StatementNode
{
    ExpressionNode getCondition();
    
    StatementNode getElseStatement();
    
    StatementNode getThenStatement();
}
