package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.WhileLoopNode;

public class WhileLoopNodeImpl extends StatementNodeImpl implements WhileLoopNode
{
    /** The loop's condition. */
    private ExpressionNode condition;

    /** The loop's statement. */
    private StatementNode statement;

    /** General constructor. */
    public WhileLoopNodeImpl(
            ExpressionNode condition,
            StatementNode statement)
    {
        super();
        this.condition = condition;
        this.statement = statement;
    }

    /**
     * Gets the loop's condition.
     * @return The loop's condition.
     */
    public ExpressionNode getCondition()
    {
        return this.condition;
    }

    /**
     * Changes the loop's condition.
     * @param condition The loop's condition.
     */
    public void setCondition(ExpressionNode condition)
    {
        if (this.condition instanceof NodeImpl)
        {
            ((NodeImpl)this.condition).setParent(null);
        }
        this.condition = condition;
        if (this.condition instanceof NodeImpl)
        {
            ((NodeImpl)this.condition).setParent(this);
        }
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
        if (this.statement instanceof NodeImpl)
        {
            ((NodeImpl)this.statement).setParent(null);
        }
        this.statement = statement;
        if (this.statement instanceof NodeImpl)
        {
            ((NodeImpl)this.statement).setParent(this);
        }
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
