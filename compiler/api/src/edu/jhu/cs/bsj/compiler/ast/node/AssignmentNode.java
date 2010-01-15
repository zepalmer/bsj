package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;

/**
 * Represents the assignment of an expression to a variable, as in
 * <pre>
 * <i>expr op expr</i>
 * </pre>
 * where <i>op</i> is one of <tt>=</tt>, <tt>+=</tt>, <tt>%=</tt>, etc.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
public interface AssignmentNode extends Node, ExpressionNode
{
    /**
     * Gets the variable to which to assign a value.
     * @return The variable to which to assign a value.
     */
    public ExpressionNode getVariable();

    /**
     * Changes the variable to which to assign a value.
     * @param variable The variable to which to assign a value.
     */
    public void setVariable(ExpressionNode variable);

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
     */
    public ExpressionNode getExpression();

    /**
     * Changes the expression to use.
     * @param expression The expression to use.
     */
    public void setExpression(ExpressionNode expression);

}
