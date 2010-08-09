package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the application of a binary operator.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BinaryExpressionNode extends Node, NonAssignmentExpressionNode
{
    /**
     * Gets the left operand of the expression.
     * @return The left operand of the expression.
     */
    public ExpressionNode getLeftOperand();
    
    /**
     * Changes the left operand of the expression.
     * @param leftOperand The left operand of the expression.
     */
    public void setLeftOperand(ExpressionNode leftOperand);
    
    /**
     * Gets the right operand of the expression.
     * @return The right operand of the expression.
     */
    public ExpressionNode getRightOperand();
    
    /**
     * Changes the right operand of the expression.
     * @param rightOperand The right operand of the expression.
     */
    public void setRightOperand(ExpressionNode rightOperand);
    
    /**
     * Gets the binary operator to apply.
     * @return The binary operator to apply.
     */
    public BinaryOperator getOperator();
    
    /**
     * Changes the binary operator to apply.
     * @param operator The binary operator to apply.
     */
    public void setOperator(BinaryOperator operator);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public BinaryExpressionNode deepCopy(BsjNodeFactory factory);
    
}
