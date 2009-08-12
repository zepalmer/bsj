package edu.jhu.cs.bsj.compiler.ast;

public interface EnhancedForLoopNode extends StatementNode
{
    ExpressionNode getExpression();
    
    StatementNode getStatement();
              
    VariableNode getVariable();              
}
