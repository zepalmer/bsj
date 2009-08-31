package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ThrowNode;

public class ThrowNodeImpl extends StatementNodeImpl implements ThrowNode
{
    /** The Throwable to throw. */
    private ExpressionNode expression;

    /** General constructor. */
    public ThrowNodeImpl(
            ExpressionNode expression)
    {
        super();
        this.expression = expression;
    }

    /**
     * Gets the Throwable to throw.
     * @return The Throwable to throw.
     */
    public ExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes the Throwable to throw.
     * @param expression The Throwable to throw.
     */
    public void setExpression(ExpressionNode expression)
    {
        this.expression = expression;
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
