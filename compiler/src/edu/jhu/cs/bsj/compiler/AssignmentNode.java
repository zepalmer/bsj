package edu.jhu.cs.bsj.compiler;

public interface AssignmentNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    ExpressionNode getVariable();
}
