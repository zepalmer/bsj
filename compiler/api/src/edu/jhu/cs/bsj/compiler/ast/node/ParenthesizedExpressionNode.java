package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

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
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getExpression() throws ClassCastException;
    
    /**
     * Gets the union object for the expression contained in this node.
     * @return A union object representing The expression contained in this node.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForExpression();
    
    /**
     * Changes the expression contained in this node.
     * @param expression The expression contained in this node.
     */
    public void setExpression(ExpressionNode expression);
    
    /**
     * Changes the expression contained in this node.
     * @param expression The expression contained in this node.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForExpression(NodeUnion<? extends ExpressionNode> expression) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ParenthesizedExpressionNode deepCopy(BsjNodeFactory factory);
    
}
