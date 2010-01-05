package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;

public class AnnotationValueNodeImpl extends NodeImpl implements AnnotationValueNode
{
    /** The identifier. */
    private IdentifierNode identifier;

    /** The expression. */
    private ExpressionNode value;

    /** General constructor. */
    public AnnotationValueNodeImpl(
            IdentifierNode identifier,
            ExpressionNode value)
    {
        super();
        this.identifier = identifier;
        this.value = value;
    }

    /**
     * Gets the identifier.
     * @return The identifier.
     */
    public IdentifierNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the identifier.
     * @param identifier The identifier.
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
     * Gets the expression.
     * @return The expression.
     */
    public ExpressionNode getValue()
    {
        return this.value;
    }

    /**
     * Changes the expression.
     * @param value The expression.
     */
    public void setValue(ExpressionNode value)
    {
        if (this.value instanceof NodeImpl)
        {
            ((NodeImpl)this.value).setParent(null);
        }
        this.value = value;
        if (this.value instanceof NodeImpl)
        {
            ((NodeImpl)this.value).setParent(this);
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
        this.identifier.receive(visitor);
        this.value.receive(visitor);
    }
}
