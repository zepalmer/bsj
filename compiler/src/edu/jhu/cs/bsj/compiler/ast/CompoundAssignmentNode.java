package edu.jhu.cs.bsj.compiler;

public interface CompoundAssignmentNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    ExpressionNode getVariable();
}
