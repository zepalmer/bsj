package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A value in an annotation which is an expression.  This value may not be an assignment expression.
 */
public interface AnnotationExpressionValueNode extends Node, AnnotationValueNode
{
    /**
     * Gets the expression.
     * @return The expression.
     */
    public ExpressionNode getExpression();

    /**
     * Changes the expression.
     * @param expression The expression.
     */
    public void setExpression(ExpressionNode expression);

}
