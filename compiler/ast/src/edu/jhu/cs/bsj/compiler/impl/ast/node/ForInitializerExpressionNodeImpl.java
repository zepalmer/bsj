package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

public class ForInitializerExpressionNodeImpl extends ForInitializerNodeImpl implements ForInitializerExpressionNode
{
    /** The expressions used in this initializer. */
    private ListNode<? extends ExpressionNode> expressions;

    /** General constructor. */
    public ForInitializerExpressionNodeImpl(
            ListNode<? extends ExpressionNode> expressions)
    {
        super();
        this.expressions = expressions;
    }

    /**
     * Gets the expressions used in this initializer.
     * @return The expressions used in this initializer.
     */
    public ListNode<? extends ExpressionNode> getExpressions()
    {
        return this.expressions;
    }

    /**
     * Changes the expressions used in this initializer.
     * @param expressions The expressions used in this initializer.
     */
    public void setExpressions(ListNode<? extends ExpressionNode> expressions)
    {
        if (this.expressions instanceof NodeImpl)
        {
            ((NodeImpl)this.expressions).setParent(null);
        }
        this.expressions = expressions;
        if (this.expressions instanceof NodeImpl)
        {
            ((NodeImpl)this.expressions).setParent(this);
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
        this.expressions.receive(visitor);
    }
}