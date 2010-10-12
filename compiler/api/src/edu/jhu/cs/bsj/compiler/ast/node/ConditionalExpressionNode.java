package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * Represents a conditional <i>expression</i>, as in:
 * <pre>
 * <i>condition</i> ? <i>expression</i> : <i>expression</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ConditionalExpressionNode extends Node, NonAssignmentExpressionNode
{
    /**
     * Gets the condition of the expression.
     * @return The condition of the expression.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getCondition()throws ClassCastException;
    
    /**
     * Gets the union object for the condition of the expression.
     * @return A union object representing The condition of the expression.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForCondition();
    
    /**
     * Changes the condition of the expression.
     * @param condition The condition of the expression.
     */
    public void setCondition(ExpressionNode condition);
    
    /**
     * Changes the condition of the expression.
     * @param condition The condition of the expression.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForCondition(NodeUnion<? extends ExpressionNode> condition) throws NullPointerException;
    
    /**
     * Gets the value of this expression when the condition is true.
     * @return The value of this expression when the condition is true.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getTrueExpression()throws ClassCastException;
    
    /**
     * Gets the union object for the value of this expression when the condition is true.
     * @return A union object representing The value of this expression when the condition is true.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForTrueExpression();
    
    /**
     * Changes the value of this expression when the condition is true.
     * @param trueExpression The value of this expression when the condition is true.
     */
    public void setTrueExpression(ExpressionNode trueExpression);
    
    /**
     * Changes the value of this expression when the condition is true.
     * @param trueExpression The value of this expression when the condition is true.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForTrueExpression(NodeUnion<? extends ExpressionNode> trueExpression) throws NullPointerException;
    
    /**
     * Gets the value of this expression when the condition is false.
     * @return The value of this expression when the condition is false.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getFalseExpression()throws ClassCastException;
    
    /**
     * Gets the union object for the value of this expression when the condition is false.
     * @return A union object representing The value of this expression when the condition is false.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForFalseExpression();
    
    /**
     * Changes the value of this expression when the condition is false.
     * @param falseExpression The value of this expression when the condition is false.
     */
    public void setFalseExpression(ExpressionNode falseExpression);
    
    /**
     * Changes the value of this expression when the condition is false.
     * @param falseExpression The value of this expression when the condition is false.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForFalseExpression(NodeUnion<? extends ExpressionNode> falseExpression) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ConditionalExpressionNode deepCopy(BsjNodeFactory factory);
    
}
