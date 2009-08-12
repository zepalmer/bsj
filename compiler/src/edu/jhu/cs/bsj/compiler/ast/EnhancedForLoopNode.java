package edu.jhu.cs.bsj.compiler;

public interface EnhancedForLoopNode extends StatementNode
{
    ExpressionNode getExpression();
    
    StatementNode getStatement();
              
    VariableNode getVariable();              
}
