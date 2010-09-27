package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

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
     * @throws ClassCastException If the value of this property is a special node.
     */
    public RestrictedPrimaryExpressionNode getArrayExpression() throws ClassCastException;
    
    /**
     * Gets the union object for the expression identifying the array.
     * @return A union object representing The expression identifying the array.
     */
    public NodeUnion<? extends RestrictedPrimaryExpressionNode> getUnionForArrayExpression();
    
    /**
     * Changes the expression identifying the array.
     * @param arrayExpression The expression identifying the array.
     */
    public void setArrayExpression(RestrictedPrimaryExpressionNode arrayExpression);
    
    /**
     * Changes the expression identifying the array.
     * @param arrayExpression The expression identifying the array.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForArrayExpression(NodeUnion<? extends RestrictedPrimaryExpressionNode> arrayExpression) throws NullPointerException;
    
    /**
     * Gets the index into the array.
     * @return The index into the array.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getIndexExpression() throws ClassCastException;
    
    /**
     * Gets the union object for the index into the array.
     * @return A union object representing The index into the array.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForIndexExpression();
    
    /**
     * Changes the index into the array.
     * @param indexExpression The index into the array.
     */
    public void setIndexExpression(ExpressionNode indexExpression);
    
    /**
     * Changes the index into the array.
     * @param indexExpression The index into the array.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForIndexExpression(NodeUnion<? extends ExpressionNode> indexExpression) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ArrayAccessNode deepCopy(BsjNodeFactory factory);
    
}
