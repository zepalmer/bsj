package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents an array access, as in:
 * <pre>
 * <i>expression</i>[<i>index</i>]
 * </pre>
 */
public interface ArrayAccessNode extends RestrictedPrimaryExpressionNode
{
    /**
     * Gets the expression identifying the array.
     * @return The expression identifying the array.
     */
    public ExpressionNode getExpression();

    /**
     * Changes the expression identifying the array.
     * @param expression The expression identifying the array.
     */
    public void setExpression(ExpressionNode expression);

    /**
     * Gets the index into the array.
     * @return The index into the array.
     */
    public ExpressionNode getIndex();

    /**
     * Changes the index into the array.
     * @param index The index into the array.
     */
    public void setIndex(ExpressionNode index);

}
