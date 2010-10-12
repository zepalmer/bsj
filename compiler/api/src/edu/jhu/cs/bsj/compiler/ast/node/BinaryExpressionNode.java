package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * Represents the application of a binary operator.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BinaryExpressionNode extends Node, NonAssignmentExpressionNode
{
    /**
     * Gets the left operand of the expression.
     * @return The left operand of the expression.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getLeftOperand()throws ClassCastException;
    
    /**
     * Gets the union object for the left operand of the expression.
     * @return A union object representing The left operand of the expression.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForLeftOperand();
    
    /**
     * Changes the left operand of the expression.
     * @param leftOperand The left operand of the expression.
     */
    public void setLeftOperand(ExpressionNode leftOperand);
    
    /**
     * Changes the left operand of the expression.
     * @param leftOperand The left operand of the expression.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForLeftOperand(NodeUnion<? extends ExpressionNode> leftOperand) throws NullPointerException;
    
    /**
     * Gets the right operand of the expression.
     * @return The right operand of the expression.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getRightOperand()throws ClassCastException;
    
    /**
     * Gets the union object for the right operand of the expression.
     * @return A union object representing The right operand of the expression.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForRightOperand();
    
    /**
     * Changes the right operand of the expression.
     * @param rightOperand The right operand of the expression.
     */
    public void setRightOperand(ExpressionNode rightOperand);
    
    /**
     * Changes the right operand of the expression.
     * @param rightOperand The right operand of the expression.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForRightOperand(NodeUnion<? extends ExpressionNode> rightOperand) throws NullPointerException;
    
    /**
     * Gets the binary operator to apply.
     * @return The binary operator to apply.
     */
    public BinaryOperator getOperator();
    
    /**
     * Changes the binary operator to apply.
     * @param operator The binary operator to apply.
     */
    public void setOperator(BinaryOperator operator);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public BinaryExpressionNode deepCopy(BsjNodeFactory factory);
    
}
