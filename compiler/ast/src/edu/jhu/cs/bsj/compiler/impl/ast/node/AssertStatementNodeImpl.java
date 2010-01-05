package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AssertStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;

public class AssertStatementNodeImpl extends StatementNodeImpl implements AssertStatementNode
{
    /** The assertion's test expression. */
    private ExpressionNode testExpression;

    /** The assertion's message expression. */
    private ExpressionNode messageExpression;

    /** General constructor. */
    public AssertStatementNodeImpl(
            ExpressionNode testExpression,
            ExpressionNode messageExpression)
    {
        super();
        this.testExpression = testExpression;
        this.messageExpression = messageExpression;
    }

    /**
     * Gets the assertion's test expression.
     * @return The assertion's test expression.
     */
    public ExpressionNode getTestExpression()
    {
        return this.testExpression;
    }

    /**
     * Changes the assertion's test expression.
     * @param testExpression The assertion's test expression.
     */
    public void setTestExpression(ExpressionNode testExpression)
    {
        if (this.testExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.testExpression).setParent(null);
        }
        this.testExpression = testExpression;
        if (this.testExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.testExpression).setParent(this);
        }
    }

    /**
     * Gets the assertion's message expression.
     * @return The assertion's message expression.
     */
    public ExpressionNode getMessageExpression()
    {
        return this.messageExpression;
    }

    /**
     * Changes the assertion's message expression.
     * @param messageExpression The assertion's message expression.
     */
    public void setMessageExpression(ExpressionNode messageExpression)
    {
        if (this.messageExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.messageExpression).setParent(null);
        }
        this.messageExpression = messageExpression;
        if (this.messageExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.messageExpression).setParent(this);
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
        this.testExpression.receive(visitor);
        this.messageExpression.receive(visitor);
    }
}
