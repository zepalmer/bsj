package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents a conditional <i>expression</i>, as in:
 * <pre>
 * <i>condition</i> ? <i>expression</i> : <i>expression</i>
 * </pre>
 */
public interface ConditionalExpressionNode extends Node, NonAssignmentExpressionNode
{
    /**
     * Gets the condition of the expression.
     * @return The condition of the expression.
     */
    public ExpressionNode getCondition();

    /**
     * Changes the condition of the expression.
     * @param condition The condition of the expression.
     */
    public void setCondition(ExpressionNode condition);

    /**
     * Gets the value of this expression when the condition is true.
     * @return The value of this expression when the condition is true.
     */
    public ExpressionNode getTrueExpression();

    /**
     * Changes the value of this expression when the condition is true.
     * @param trueExpression The value of this expression when the condition is true.
     */
    public void setTrueExpression(ExpressionNode trueExpression);

    /**
     * Gets the value of this expression when the condition is false.
     * @return The value of this expression when the condition is false.
     */
    public ExpressionNode getFalseExpression();

    /**
     * Changes the value of this expression when the condition is false.
     * @param falseExpression The value of this expression when the condition is false.
     */
    public void setFalseExpression(ExpressionNode falseExpression);

}
