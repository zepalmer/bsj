package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionStatementNode;

public class ExpressionStatementNodeImpl extends StatementNodeImpl implements ExpressionStatementNode
{
    /** This statement's expression. */
    private ExpressionNode expression;

    /** General constructor. */
    public ExpressionStatementNodeImpl(
            ExpressionNode expression)
    {
        super();
        this.expression = expression;
    }

    /**
     * Gets this statement's expression.
     * @return This statement's expression.
     */
    public ExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes this statement's expression.
     * @param expression This statement's expression.
     */
    public void setExpression(ExpressionNode expression)
    {
        if (this.expression instanceof NodeImpl)
        {
            ((NodeImpl)this.expression).setParent(null);
        }
        this.expression = expression;
        if (this.expression instanceof NodeImpl)
        {
            ((NodeImpl)this.expression).setParent(this);
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
