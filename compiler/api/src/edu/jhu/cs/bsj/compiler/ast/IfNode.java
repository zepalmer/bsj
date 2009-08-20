package edu.jhu.cs.bsj.compiler.ast;

public interface IfNode extends StatementNode
{
    ExpressionNode getCondition();
    
    StatementNode getElseStatement();
    
    StatementNode getThenStatement();
}
