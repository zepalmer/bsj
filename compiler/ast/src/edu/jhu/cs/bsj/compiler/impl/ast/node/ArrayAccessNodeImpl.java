package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayAccessNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.RestrictedPrimaryExpressionNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
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
        this.arrayExpression.receiveTyped(visitor);
        this.indexExpression.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitArrayAccessNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitRestrictedPrimaryExpressionNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitRestrictedPrimaryExpressionNodeStop(this);
        visitor.visitNodeStart(this);
        visitor.visitArrayAccessNodeStart(this, true);
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
        list.add(getArrayExpression());
        list.add(getIndexExpression());
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

    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p The parameter to pass to the operation.
     * @return The result of the operation.
     */
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
    {
        return operation.executeArrayAccessNode(this, p);
    }
}
