package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementExpressionNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ExpressionStatementNodeImpl extends NodeImpl implements ExpressionStatementNode
{
    /** This statement's expression. */
    private StatementExpressionNode expression;

    /** General constructor. */
    public ExpressionStatementNodeImpl(
            StatementExpressionNode expression)
    {
        super();
        this.expression = expression;
    }

    /**
     * Gets this statement's expression.
     * @return This statement's expression.
     */
    public StatementExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes this statement's expression.
     * @param expression This statement's expression.
     */
    public void setExpression(StatementExpressionNode expression)
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
        this.expression.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitExpressionStatementNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStatementNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitStatementNodeStop(this);
        visitor.visitNodeStart(this);
        visitor.visitExpressionStatementNodeStart(this, true);
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
        list.add(this.expression);
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
        sb.append(']');
        return sb.toString();
    }
}
