package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayAccessNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.RestrictedPrimaryExpressionNode;

public class ArrayAccessNodeImpl extends NodeImpl implements ArrayAccessNode
{
    /** The expression identifying the array. */
    private RestrictedPrimaryExpressionNode arrayExpression;

    /** The index into the array. */
    private ExpressionNode indexExpression;

    /** General constructor. */
    public ArrayAccessNodeImpl(
            RestrictedPrimaryExpressionNode arrayExpression,
            ExpressionNode indexExpression)
    {
        super();
        this.arrayExpression = arrayExpression;
        this.indexExpression = indexExpression;
    }

    /**
     * Gets the expression identifying the array.
     * @return The expression identifying the array.
     */
    public RestrictedPrimaryExpressionNode getArrayExpression()
    {
        return this.arrayExpression;
    }

    /**
     * Changes the expression identifying the array.
     * @param arrayExpression The expression identifying the array.
     */
    public void setArrayExpression(RestrictedPrimaryExpressionNode arrayExpression)
    {
        if (this.arrayExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.arrayExpression).setParent(null);
        }
        this.arrayExpression = arrayExpression;
        if (this.arrayExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.arrayExpression).setParent(this);
        }
    }

    /**
     * Gets the index into the array.
     * @return The index into the array.
     */
    public ExpressionNode getIndexExpression()
    {
        return this.indexExpression;
    }

    /**
     * Changes the index into the array.
     * @param indexExpression The index into the array.
     */
    public void setIndexExpression(ExpressionNode indexExpression)
    {
        if (this.indexExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.indexExpression).setParent(null);
        }
        this.indexExpression = indexExpression;
        if (this.indexExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.indexExpression).setParent(this);
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
        this.arrayExpression.receive(visitor);
        this.indexExpression.receive(visitor);
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
        list.add(this.arrayExpression);
        list.add(this.indexExpression);
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
        sb.append("arrayExpression=");
        sb.append(this.arrayExpression == null? "null" : this.arrayExpression.getClass().getSimpleName());
        sb.append(',');
        sb.append("indexExpression=");
        sb.append(this.indexExpression == null? "null" : this.indexExpression.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
