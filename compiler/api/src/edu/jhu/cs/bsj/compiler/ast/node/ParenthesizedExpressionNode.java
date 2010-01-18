package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A node representing a parenthesized expression, as in:
 * <pre>
 * (<i>expr</i>)
 * </pre>
 * This node is made explicit in this AST because Java distinguishes between primary expressions and other types
 * of expressions.  For example, the ternary conditional operator (<tt>?:</tt>) is not a primary expression, but
 * there is a big difference between <tt>b?x:y.z</tt> and <tt>(b?x:y).z</tt>.  However, the field selection node
 * (which represents <tt>a.z</tt>) expects a primary expression; thus, without this node, there would be no way
 * to express <tt>(b?x:y).z</tt>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ParenthesizedExpressionNode extends Node, RestrictedPrimaryExpressionNode
{
    /**
     * Gets the expression contained in this node.
     * @return The expression contained in this node.
     */
    public ExpressionNode getExpression();

    /**
     * Changes the expression contained in this node.
     * @param expression The expression contained in this node.
     */
    public void setExpression(ExpressionNode expression);

}
