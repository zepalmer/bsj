package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * Represents the assignment of an expression to a variable, as in
 * <pre>
 * <i>expr op expr</i>
 * </pre>
 * where <i>op</i> is one of <tt>=</tt>, <tt>+=</tt>, <tt>%=</tt>, etc.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AssignmentNode extends Node, StatementExpressionNode
{
    /**
     * Gets the variable to which to assign a value.
     * @return The variable to which to assign a value.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getVariable()throws ClassCastException;
    
    /**
     * Gets the union object for the variable to which to assign a value.
     * @return A union object representing The variable to which to assign a value.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForVariable();
    
    /**
     * Changes the variable to which to assign a value.
     * @param variable The variable to which to assign a value.
     */
    public void setVariable(ExpressionNode variable);
    
    /**
     * Changes the variable to which to assign a value.
     * @param variable The variable to which to assign a value.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForVariable(NodeUnion<? extends ExpressionNode> variable) throws NullPointerException;
    
    /**
     * Gets the assignment operator indicating the operation to perform.
     * @return The assignment operator indicating the operation to perform.
     */
    public AssignmentOperator getOperator();
    
    /**
     * Changes the assignment operator indicating the operation to perform.
     * @param operator The assignment operator indicating the operation to perform.
     */
    public void setOperator(AssignmentOperator operator);
    
    /**
     * Gets the expression to use.
     * @return The expression to use.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getExpression()throws ClassCastException;
    
    /**
     * Gets the union object for the expression to use.
     * @return A union object representing The expression to use.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForExpression();
    
    /**
     * Changes the expression to use.
     * @param expression The expression to use.
     */
    public void setExpression(ExpressionNode expression);
    
    /**
     * Changes the expression to use.
     * @param expression The expression to use.
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
    public AssignmentNode deepCopy(BsjNodeFactory factory);
    
}
