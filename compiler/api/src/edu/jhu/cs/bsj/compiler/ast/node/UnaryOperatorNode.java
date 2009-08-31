package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.UnaryOperator;

/**
 * A node for unary expressions, such as:
 * <pre>
 * ~0
 * </pre>
 * or
 * <pre>
 * x++
 * </pre>
 */
public interface UnaryOperatorNode extends ExpressionNode
{
    /**
     * Gets the expression on which to operate.
     * @return The expression on which to operate.
     */
    public ExpressionNode getExpression();

    /**
     * Changes the expression on which to operate.
     * @param expression The expression on which to operate.
     */
    public void setExpression(ExpressionNode expression);

    /**
     * Gets the operator to apply.
     * @return The operator to apply.
     */
    public UnaryOperator getOperator();

    /**
     * Changes the operator to apply.
     * @param operator The operator to apply.
     */
    public void setOperator(UnaryOperator operator);

}
