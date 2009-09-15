package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.MemberSelectNode;

public class MemberSelectNodeImpl extends ExpressionNodeImpl implements MemberSelectNode
{
    /** The expression from which to select. */
    private ExpressionNode expression;

    /** The identifier to select. */
    private IdentifierNode identifier;

    /** General constructor. */
    public MemberSelectNodeImpl(
            ExpressionNode expression,
            IdentifierNode identifier)
    {
        super();
        this.expression = expression;
        this.identifier = identifier;
    }

    /**
     * Gets the expression from which to select.
     * @return The expression from which to select.
     */
    public ExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes the expression from which to select.
     * @param expression The expression from which to select.
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
     * Gets the identifier to select.
     * @return The identifier to select.
     */
    public IdentifierNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the identifier to select.
     * @param identifier The identifier to select.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
        if (this.identifier instanceof NodeImpl)
        {
            ((NodeImpl)this.identifier).setParent(null);
        }
        this.identifier = identifier;
        if (this.identifier instanceof NodeImpl)
        {
            ((NodeImpl)this.identifier).setParent(this);
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
        this.identifier.receive(visitor);
    }
}