package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ConditionalExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ConditionalExpressionNodeImpl extends NodeImpl implements ConditionalExpressionNode
{
    /** The condition of the expression. */
    private ExpressionNode condition;

    /** The value of this expression when the condition is true. */
    private ExpressionNode trueExpression;

    /** The value of this expression when the condition is false. */
    private ExpressionNode falseExpression;

    /** General constructor. */
    public ConditionalExpressionNodeImpl(
            ExpressionNode condition,
            ExpressionNode trueExpression,
            ExpressionNode falseExpression)
    {
        super();
        this.condition = condition;
        this.trueExpression = trueExpression;
        this.falseExpression = falseExpression;
    }

    /**
     * Gets the condition of the expression.
     * @return The condition of the expression.
     */
    public ExpressionNode getCondition()
    {
        return this.condition;
    }

    /**
     * Changes the condition of the expression.
     * @param condition The condition of the expression.
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
     * Gets the value of this expression when the condition is true.
     * @return The value of this expression when the condition is true.
     */
    public ExpressionNode getTrueExpression()
    {
        return this.trueExpression;
    }

    /**
     * Changes the value of this expression when the condition is true.
     * @param trueExpression The value of this expression when the condition is true.
     */
    public void setTrueExpression(ExpressionNode trueExpression)
    {
        if (this.trueExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.trueExpression).setParent(null);
        }
        this.trueExpression = trueExpression;
        if (this.trueExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.trueExpression).setParent(this);
        }
    }

    /**
     * Gets the value of this expression when the condition is false.
     * @return The value of this expression when the condition is false.
     */
    public ExpressionNode getFalseExpression()
    {
        return this.falseExpression;
    }

    /**
     * Changes the value of this expression when the condition is false.
     * @param falseExpression The value of this expression when the condition is false.
     */
    public void setFalseExpression(ExpressionNode falseExpression)
    {
        if (this.falseExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.falseExpression).setParent(null);
        }
        this.falseExpression = falseExpression;
        if (this.falseExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.falseExpression).setParent(this);
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
        this.condition.receive(visitor);
        this.trueExpression.receive(visitor);
        this.falseExpression.receive(visitor);
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
        this.condition.receiveTyped(visitor);
        this.trueExpression.receiveTyped(visitor);
        this.falseExpression.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitConditionalExpressionNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitNonAssignmentExpressionNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNonAssignmentExpressionNodeStop(this);
        visitor.visitNodeStart(this);
        visitor.visitConditionalExpressionNodeStart(this, true);
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
        list.add(getCondition());
        list.add(getTrueExpression());
        list.add(getFalseExpression());
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
        sb.append("condition=");
        sb.append(this.condition == null? "null" : this.condition.getClass().getSimpleName());
        sb.append(',');
        sb.append("trueExpression=");
        sb.append(this.trueExpression == null? "null" : this.trueExpression.getClass().getSimpleName());
        sb.append(',');
        sb.append("falseExpression=");
        sb.append(this.falseExpression == null? "null" : this.falseExpression.getClass().getSimpleName());
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
        return operation.executeConditionalExpressionNode(this, p);
    }
}
