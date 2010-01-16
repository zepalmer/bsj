package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IfNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
public class IfNodeImpl extends NodeImpl implements IfNode
{
    /** The condition. */
    private ExpressionNode condition;

    /** The then branch's statement. */
    private StatementNode thenStatement;

    /** The else branch's statement. */
    private StatementNode elseStatement;

    /** General constructor. */
    public IfNodeImpl(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement)
    {
        super();
        this.condition = condition;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
    }

    /**
     * Gets the condition.
     * @return The condition.
     */
    public ExpressionNode getCondition()
    {
        return this.condition;
    }

    /**
     * Changes the condition.
     * @param condition The condition.
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
     * Gets the then branch's statement.
     * @return The then branch's statement.
     */
    public StatementNode getThenStatement()
    {
        return this.thenStatement;
    }

    /**
     * Changes the then branch's statement.
     * @param thenStatement The then branch's statement.
     */
    public void setThenStatement(StatementNode thenStatement)
    {
        if (this.thenStatement instanceof NodeImpl)
        {
            ((NodeImpl)this.thenStatement).setParent(null);
        }
        this.thenStatement = thenStatement;
        if (this.thenStatement instanceof NodeImpl)
        {
            ((NodeImpl)this.thenStatement).setParent(this);
        }
    }

    /**
     * Gets the else branch's statement.
     * @return The else branch's statement.
     */
    public StatementNode getElseStatement()
    {
        return this.elseStatement;
    }

    /**
     * Changes the else branch's statement.
     * @param elseStatement The else branch's statement.
     */
    public void setElseStatement(StatementNode elseStatement)
    {
        if (this.elseStatement instanceof NodeImpl)
        {
            ((NodeImpl)this.elseStatement).setParent(null);
        }
        this.elseStatement = elseStatement;
        if (this.elseStatement instanceof NodeImpl)
        {
            ((NodeImpl)this.elseStatement).setParent(this);
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
        this.thenStatement.receive(visitor);
        this.elseStatement.receive(visitor);
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
        this.thenStatement.receiveTyped(visitor);
        this.elseStatement.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitIfNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStatementNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitStatementNodeStop(this);
        visitor.visitNodeStart(this);
        visitor.visitIfNodeStart(this, true);
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
        list.add(this.condition);
        list.add(this.thenStatement);
        list.add(this.elseStatement);
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
        sb.append("thenStatement=");
        sb.append(this.thenStatement == null? "null" : this.thenStatement.getClass().getSimpleName());
        sb.append(',');
        sb.append("elseStatement=");
        sb.append(this.elseStatement == null? "null" : this.elseStatement.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
