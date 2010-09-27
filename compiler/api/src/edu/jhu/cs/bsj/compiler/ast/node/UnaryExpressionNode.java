package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.UnaryOperator;

/**
 * A node for non-statement unary expressions, such as
 * <pre>
 * ~0
 * </pre>
 * or
 * <pre>
 * -x
 * </pre>
 * Note that this node does not cover those unary expressions which are also statement expressions (increment and
 * decrement); for those expressions, nodes of type {@link UnaryStatementExpressionNode} should be used.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface UnaryExpressionNode extends Node, NonAssignmentExpressionNode
{
    /**
     * Gets the expression on which to operate.
     * @return The expression on which to operate.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getExpression() throws ClassCastException;
    
    /**
     * Gets the union object for the expression on which to operate.
     * @return A union object representing The expression on which to operate.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForExpression();
    
    /**
     * Changes the expression on which to operate.
     * @param expression The expression on which to operate.
     */
    public void setExpression(ExpressionNode expression);
    
    /**
     * Changes the expression on which to operate.
     * @param expression The expression on which to operate.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForExpression(NodeUnion<? extends ExpressionNode> expression) throws NullPointerException;
    
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
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public UnaryExpressionNode deepCopy(BsjNodeFactory factory);
    
}
