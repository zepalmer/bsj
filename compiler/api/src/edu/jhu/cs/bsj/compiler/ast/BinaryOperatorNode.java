package edu.jhu.cs.bsj.compiler.ast;

public interface BinaryOperatorNode extends ExpressionNode
{
    ExpressionNode getLeftOperand();
    
    ExpressionNode getRightOperand();
}
