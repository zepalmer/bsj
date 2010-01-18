package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * Represents an array access, as in:
 * <pre>
 * <i>expression</i>[<i>index</i>]
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ArrayAccessNode extends Node, RestrictedPrimaryExpressionNode
{
    /**
     * Gets the expression identifying the array.
     * @return The expression identifying the array.
     */
    public RestrictedPrimaryExpressionNode getArrayExpression();

    /**
     * Changes the expression identifying the array.
     * @param arrayExpression The expression identifying the array.
     */
    public void setArrayExpression(RestrictedPrimaryExpressionNode arrayExpression);

    /**
     * Gets the index into the array.
     * @return The index into the array.
     */
    public ExpressionNode getIndexExpression();

    /**
     * Changes the index into the array.
     * @param indexExpression The index into the array.
     */
    public void setIndexExpression(ExpressionNode indexExpression);

}
