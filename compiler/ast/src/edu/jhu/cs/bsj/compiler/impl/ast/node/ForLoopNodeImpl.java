package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;

public class ForLoopNodeImpl extends NodeImpl implements ForLoopNode
{
    /** The initializer used for this for loop. */
    private ForInitializerNode initializer;

    /** The loop's termination condition. */
    private ExpressionNode condition;

    /** The loop's update operation. */
    private ListNode<ExpressionNode> update;

    /** The loop's statement. */
    private StatementNode statement;

    /** General constructor. */
    public ForLoopNodeImpl(
            ForInitializerNode initializer,
            ExpressionNode condition,
            ListNode<ExpressionNode> update,
            StatementNode statement)
    {
        super();
        this.initializer = initializer;
        this.condition = condition;
        this.update = update;
        this.statement = statement;
    }

    /**
     * Gets the initializer used for this for loop.
     * @return The initializer used for this for loop.
     */
    public ForInitializerNode getInitializer()
    {
        return this.initializer;
    }

    /**
     * Changes the initializer used for this for loop.
     * @param initializer The initializer used for this for loop.
     */
    public void setInitializer(ForInitializerNode initializer)
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
     * Gets the loop's update operation.
     * @return The loop's update operation.
     */
    public ListNode<ExpressionNode> getUpdate()
    {
        return this.update;
    }

    /**
     * Changes the loop's update operation.
     * @param update The loop's update operation.
     */
    public void setUpdate(ListNode<ExpressionNode> update)
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
     * Handles the visitation of this node's children for the provided visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        super.receiveToChildren(visitor);
        this.initializer.receive(visitor);
        this.condition.receive(visitor);
        this.update.receive(visitor);
        this.statement.receive(visitor);
    }

    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(this.initializer);
        list.add(this.condition);
        list.add(this.update);
        list.add(this.statement);
        return list;
    }

    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('[');
        sb.append("initializer=");
        sb.append(this.initializer == null? "null" : this.initializer.getClass().getSimpleName());
        sb.append(',');
        sb.append("condition=");
        sb.append(this.condition == null? "null" : this.condition.getClass().getSimpleName());
        sb.append(',');
        sb.append("update=");
        sb.append(this.update == null? "null" : this.update.getClass().getSimpleName());
        sb.append(',');
        sb.append("statement=");
        sb.append(this.statement == null? "null" : this.statement.getClass().getSimpleName());
        return sb.toString();
    }
}
