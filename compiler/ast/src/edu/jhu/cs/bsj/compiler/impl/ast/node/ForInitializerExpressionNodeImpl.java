package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
public class ForInitializerExpressionNodeImpl extends NodeImpl implements ForInitializerExpressionNode
{
    /** The expressions used in this initializer. */
    private ListNode<ExpressionNode> expressions;

    /** General constructor. */
    public ForInitializerExpressionNodeImpl(
            ListNode<ExpressionNode> expressions)
    {
        super();
        this.expressions = expressions;
    }

    /**
     * Gets the expressions used in this initializer.
     * @return The expressions used in this initializer.
     */
    public ListNode<ExpressionNode> getExpressions()
    {
        return this.expressions;
    }

    /**
     * Changes the expressions used in this initializer.
     * @param expressions The expressions used in this initializer.
     */
    public void setExpressions(ListNode<ExpressionNode> expressions)
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
        this.expressions.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitForInitializerExpressionNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitForInitializerNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitForInitializerNodeStop(this);
        visitor.visitNodeStart(this);
        visitor.visitForInitializerExpressionNodeStart(this, true);
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
        list.add(this.expressions);
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
        sb.append("expressions=");
        sb.append(this.expressions == null? "null" : this.expressions.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
