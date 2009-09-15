package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IfNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;

public class IfNodeImpl extends StatementNodeImpl implements IfNode
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
}