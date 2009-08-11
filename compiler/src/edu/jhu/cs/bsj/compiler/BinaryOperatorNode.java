package edu.jhu.cs.bsj.compiler;

public interface BinaryOperatorNode extends ExpressionNode
{
    ExpressionNode getLeftOperand();
    
    ExpressionNode getRightOperand();
}
