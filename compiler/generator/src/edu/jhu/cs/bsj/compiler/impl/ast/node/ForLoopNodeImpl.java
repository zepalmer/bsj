package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ForLoopNodeImpl extends NodeImpl implements ForLoopNode
{
    /** The initializer used for this for loop. */
    private ForInitializerNode initializer;

    /** The loop's termination condition. */
    private ExpressionNode condition;

    /** The loop's update operation. */
    private ListNode<StatementExpressionNode> update;

    /** The loop's statement. */
    private StatementNode statement;

    /** General constructor. */
    public ForLoopNodeImpl(
            ForInitializerNode initializer,
            ExpressionNode condition,
            ListNode<StatementExpressionNode> update,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        setInitializer(initializer);
        setCondition(condition);
        setUpdate(update);
        setStatement(statement);
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
    public ListNode<StatementExpressionNode> getUpdate()
    {
        return this.update;
    }

    /**
     * Changes the loop's update operation.
     * @param update The loop's update operation.
     */
    public void setUpdate(ListNode<StatementExpressionNode> update)
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
        if (this.initializer != null)
        {
            this.initializer.receive(visitor);
        }
        if (this.condition != null)
        {
            this.condition.receive(visitor);
        }
        if (this.update != null)
        {
            this.update.receive(visitor);
        }
        if (this.statement != null)
        {
            this.statement.receive(visitor);
        }
    }

    /**
     * Handles the visitation of this node's children for the provided typed visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveTypedToChildren(BsjTypedNodeVisitor visitor)
    {
        super.receiveTypedToChildren(visitor);
        if (this.initializer != null)
        {
            this.initializer.receiveTyped(visitor);
        }
        if (this.condition != null)
        {
            this.condition.receiveTyped(visitor);
        }
        if (this.update != null)
        {
            this.update.receiveTyped(visitor);
        }
        if (this.statement != null)
        {
            this.statement.receiveTyped(visitor);
        }
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitForLoopNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStatementNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitStatementNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitForLoopNodeStop(this, true);
        visitor.visitStopEnd(this);
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
        list.add(getInitializer());
        list.add(getCondition());
        list.add(getUpdate());
        list.add(getStatement());
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
        sb.append(this.getInitializer() == null? "null" : this.getInitializer().getClass().getSimpleName());
        sb.append(',');
        sb.append("condition=");
        sb.append(this.getCondition() == null? "null" : this.getCondition().getClass().getSimpleName());
        sb.append(',');
        sb.append("update=");
        sb.append(this.getUpdate() == null? "null" : this.getUpdate().getClass().getSimpleName());
        sb.append(',');
        sb.append("statement=");
        sb.append(this.getStatement() == null? "null" : this.getStatement().getClass().getSimpleName());
        sb.append(',');
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + (this.getStartLocation() != null ? this.getStartLocation().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + (this.getStopLocation() != null ? this.getStopLocation().getClass().getSimpleName() : "null"));
        sb.append(']');
        return sb.toString();
    }

    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
    {
        return operation.executeForLoopNode(this, p);
    }

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ForLoopNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeForLoopNode(
                getInitializer().deepCopy(factory),
                getCondition().deepCopy(factory),
                getUpdate().deepCopy(factory),
                getStatement().deepCopy(factory));
    }
}
