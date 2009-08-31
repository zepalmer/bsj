package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.UnaryOperator;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnaryOperatorNode;

public class UnaryOperatorNodeImpl extends ExpressionNodeImpl implements UnaryOperatorNode
{
    /** The expression on which to operate. */
    private ExpressionNode expression;

    /** The operator to apply. */
    private UnaryOperator operator;

    /** General constructor. */
    public UnaryOperatorNodeImpl(
            ExpressionNode expression,
            UnaryOperator operator)
    {
        super();
        this.expression = expression;
        this.operator = operator;
    }

    /**
     * Gets the expression on which to operate.
     * @return The expression on which to operate.
     */
    public ExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes the expression on which to operate.
     * @param expression The expression on which to operate.
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
     * Gets the operator to apply.
     * @return The operator to apply.
     */
    public UnaryOperator getOperator()
    {
        return this.operator;
    }

    /**
     * Changes the operator to apply.
     * @param operator The operator to apply.
     */
    public void setOperator(UnaryOperator operator)
    {
        this.operator = operator;
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
