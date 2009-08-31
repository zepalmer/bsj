package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BinaryOperatorNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;

public class BinaryOperatorNodeImpl extends ExpressionNodeImpl implements BinaryOperatorNode
{
    /** The left operand of the expression. */
    private ExpressionNode leftOperand;

    /** The right operand of the expression. */
    private ExpressionNode rightOperand;

    /** The binary operator to apply. */
    private BinaryOperator operator;

    /** General constructor. */
    public BinaryOperatorNodeImpl(
            ExpressionNode leftOperand,
            ExpressionNode rightOperand,
            BinaryOperator operator)
    {
        super();
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    /**
     * Gets the left operand of the expression.
     * @return The left operand of the expression.
     */
    public ExpressionNode getLeftOperand()
    {
        return this.leftOperand;
    }

    /**
     * Changes the left operand of the expression.
     * @param leftOperand The left operand of the expression.
     */
    public void setLeftOperand(ExpressionNode leftOperand)
    {
        this.leftOperand = leftOperand;
    }

    /**
     * Gets the right operand of the expression.
     * @return The right operand of the expression.
     */
    public ExpressionNode getRightOperand()
    {
        return this.rightOperand;
    }

    /**
     * Changes the right operand of the expression.
     * @param rightOperand The right operand of the expression.
     */
    public void setRightOperand(ExpressionNode rightOperand)
    {
        this.rightOperand = rightOperand;
    }

    /**
     * Gets the binary operator to apply.
     * @return The binary operator to apply.
     */
    public BinaryOperator getOperator()
    {
        return this.operator;
    }

    /**
     * Changes the binary operator to apply.
     * @param operator The binary operator to apply.
     */
    public void setOperator(BinaryOperator operator)
    {
        this.operator = operator;
    }

    /**
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
