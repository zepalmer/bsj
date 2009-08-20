package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for binary operators.
 */
public interface BinaryOperatorNode extends ExpressionNode
{
    ExpressionNode getLeftOperand();
    
    ExpressionNode getRightOperand();
}
