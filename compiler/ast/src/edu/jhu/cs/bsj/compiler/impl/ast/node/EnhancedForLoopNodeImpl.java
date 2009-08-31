package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.EnhancedForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;

public class EnhancedForLoopNodeImpl extends StatementNodeImpl implements EnhancedForLoopNode
{
    /** The iterator variable. */
    private VariableNode variable;

    /** The loop's iterable expression. */
    private ExpressionNode expression;

    /** The loop's statement. */
    private StatementNode statement;

    /** General constructor. */
    public EnhancedForLoopNodeImpl(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement)
    {
        super();
        this.variable = variable;
        this.expression = expression;
        this.statement = statement;
    }

    /**
     * Gets the iterator variable.
     * @return The iterator variable.
     */
    public VariableNode getVariable()
    {
        return this.variable;
    }

    /**
     * Changes the iterator variable.
     * @param variable The iterator variable.
     */
    public void setVariable(VariableNode variable)
    {
        this.variable = variable;
    }

    /**
     * Gets the loop's iterable expression.
     * @return The loop's iterable expression.
     */
    public ExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes the loop's iterable expression.
     * @param expression The loop's iterable expression.
     */
    public void setExpression(ExpressionNode expression)
    {
        this.expression = expression;
    }

    /**
     * Gets the loop's statement.
     * @return The loop's statement.
     */
    public StatementNode getStatement()
    {
        return this.statement;
    }

    /**
     * Changes the loop's statement.
     * @param statement The loop's statement.
     */
    public void setStatement(StatementNode statement)
    {
        this.statement = statement;
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
