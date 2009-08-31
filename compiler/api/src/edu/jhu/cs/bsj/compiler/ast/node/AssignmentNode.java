package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents the assignment of an expression to a variable.
 */
public interface AssignmentNode extends ExpressionNode
{
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

}
