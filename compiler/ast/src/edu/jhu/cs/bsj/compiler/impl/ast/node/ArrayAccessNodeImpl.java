package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayAccessNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;

public class ArrayAccessNodeImpl extends ExpressionNodeImpl implements ArrayAccessNode
{
    /** The expression identifying the array. */
    private ExpressionNode expression;

    /** The index into the array. */
    private ExpressionNode index;

    /** General constructor. */
    public ArrayAccessNodeImpl(
            ExpressionNode expression,
            ExpressionNode index)
    {
        super();
        this.expression = expression;
        this.index = index;
    }

    /**
     * Gets the expression identifying the array.
     * @return The expression identifying the array.
     */
    public ExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes the expression identifying the array.
     * @param expression The expression identifying the array.
     */
    public void setExpression(ExpressionNode expression)
    {
        this.expression = expression;
    }

    /**
     * Gets the index into the array.
     * @return The index into the array.
     */
    public ExpressionNode getIndex()
    {
        return this.index;
    }

    /**
     * Changes the index into the array.
     * @param index The index into the array.
     */
    public void setIndex(ExpressionNode index)
    {
        this.index = index;
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
