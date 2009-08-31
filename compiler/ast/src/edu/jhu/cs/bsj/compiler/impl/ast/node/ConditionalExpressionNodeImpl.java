package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ConditionalExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;

public class ConditionalExpressionNodeImpl extends ExpressionNodeImpl implements ConditionalExpressionNode
{
    /** The condition of the expression. */
    private ExpressionNode condition;

    /** The value of this expression when the condition is true. */
    private ExpressionNode trueExpression;

    /** The value of this expression when the condition is false. */
    private ExpressionNode falseExpression;

    /** General constructor. */
    public ConditionalExpressionNodeImpl(
            ExpressionNode condition,
            ExpressionNode trueExpression,
            ExpressionNode falseExpression)
    {
        super();
        this.condition = condition;
        this.trueExpression = trueExpression;
        this.falseExpression = falseExpression;
    }

    /**
     * Gets the condition of the expression.
     * @return The condition of the expression.
     */
    public ExpressionNode getCondition()
    {
        return this.condition;
    }

    /**
     * Changes the condition of the expression.
     * @param condition The condition of the expression.
     */
    public void setCondition(ExpressionNode condition)
    {
        this.condition = condition;
    }

    /**
     * Gets the value of this expression when the condition is true.
     * @return The value of this expression when the condition is true.
     */
    public ExpressionNode getTrueExpression()
    {
        return this.trueExpression;
    }

    /**
     * Changes the value of this expression when the condition is true.
     * @param trueExpression The value of this expression when the condition is true.
     */
    public void setTrueExpression(ExpressionNode trueExpression)
    {
        this.trueExpression = trueExpression;
    }

    /**
     * Gets the value of this expression when the condition is false.
     * @return The value of this expression when the condition is false.
     */
    public ExpressionNode getFalseExpression()
    {
        return this.falseExpression;
    }

    /**
     * Changes the value of this expression when the condition is false.
     * @param falseExpression The value of this expression when the condition is false.
     */
    public void setFalseExpression(ExpressionNode falseExpression)
    {
        this.falseExpression = falseExpression;
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
