package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;

public class ForLoopNodeImpl extends StatementNodeImpl implements ForLoopNode
{
    /** The iterator variable. */
    private ListNode<? extends StatementNode> initializer;

    /** The loop's update operation. */
    private ListNode<? extends ExpressionStatementNode> update;

    /** The loop's termination condition. */
    private ExpressionNode condition;

    /** The loop's statement. */
    private StatementNode statement;

    /** General constructor. */
    public ForLoopNodeImpl(
            ListNode<? extends StatementNode> initializer,
            ListNode<? extends ExpressionStatementNode> update,
            ExpressionNode condition,
            StatementNode statement)
    {
        super();
        this.initializer = initializer;
        this.update = update;
        this.condition = condition;
        this.statement = statement;
    }

    /**
     * Gets the iterator variable.
     * @return The iterator variable.
     */
    public ListNode<? extends StatementNode> getInitializer()
    {
        return this.initializer;
    }

    /**
     * Changes the iterator variable.
     * @param initializer The iterator variable.
     */
    public void setInitializer(ListNode<? extends StatementNode> initializer)
    {
        if (this.initializer instanceof NodeImpl)
        {
            ((NodeImpl)this.initializer).setParent(null);
        }
        this.initializer = initializer;
        if (this.initializer instanceof NodeImpl)
        {
            ((NodeImpl)this.initializer).setParent(this);
        }
    }

    /**
     * Gets the loop's update operation.
     * @return The loop's update operation.
     */
    public ListNode<? extends ExpressionStatementNode> getUpdate()
    {
        return this.update;
    }

    /**
     * Changes the loop's update operation.
     * @param update The loop's update operation.
     */
    public void setUpdate(ListNode<? extends ExpressionStatementNode> update)
    {
        if (this.update instanceof NodeImpl)
        {
            ((NodeImpl)this.update).setParent(null);
        }
        this.update = update;
        if (this.update instanceof NodeImpl)
        {
            ((NodeImpl)this.update).setParent(this);
        }
    }

    /**
     * Gets the loop's termination condition.
     * @return The loop's termination condition.
     */
    public ExpressionNode getCondition()
    {
        return this.condition;
    }

    /**
     * Changes the loop's termination condition.
     * @param condition The loop's termination condition.
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
