package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AssignmentNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;

public class AssignmentNodeImpl extends ExpressionNodeImpl implements AssignmentNode
{
    /** The expression to use. */
    private ExpressionNode expression;

    /** The variable to which to assign a value. */
    private ExpressionNode variable;

    /** General constructor. */
    public AssignmentNodeImpl(
            ExpressionNode expression,
            ExpressionNode variable)
    {
        super();
        this.expression = expression;
        this.variable = variable;
    }

    /**
     * Gets the expression to use.
     * @return The expression to use.
     */
    public ExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes the expression to use.
     * @param expression The expression to use.
     */
    public void setExpression(ExpressionNode expression)
    {
        this.expression = expression;
    }

    /**
     * Gets the variable to which to assign a value.
     * @return The variable to which to assign a value.
     */
    public ExpressionNode getVariable()
    {
        return this.variable;
    }

    /**
     * Changes the variable to which to assign a value.
     * @param variable The variable to which to assign a value.
     */
    public void setVariable(ExpressionNode variable)
    {
        this.variable = variable;
    }

    /**
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
