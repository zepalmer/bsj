package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.UnaryOperator;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnaryOperatorNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
public class UnaryOperatorNodeImpl extends NodeImpl implements UnaryOperatorNode
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
        this.expression.receive(visitor);
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
        list.add(this.expression);
        list.add(this.operator);
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
        sb.append("expression=");
        sb.append(this.expression == null? "null" : this.expression.getClass().getSimpleName());
        sb.append(',');
        sb.append("operator=");
        sb.append(String.valueOf(this.operator) + ":" + this.operator.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
