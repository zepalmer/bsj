package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.FieldAccessByExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimaryExpressionNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
public class FieldAccessByExpressionNodeImpl extends NodeImpl implements FieldAccessByExpressionNode
{
    /** The expression from which the field is being selected. */
    private PrimaryExpressionNode expression;

    /** The name of the field. */
    private IdentifierNode identifier;

    /** General constructor. */
    public FieldAccessByExpressionNodeImpl(
            PrimaryExpressionNode expression,
            IdentifierNode identifier)
    {
        super();
        this.expression = expression;
        this.identifier = identifier;
    }

    /**
     * Gets the expression from which the field is being selected.
     * @return The expression from which the field is being selected.
     */
    public PrimaryExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes the expression from which the field is being selected.
     * @param expression The expression from which the field is being selected.
     */
    public void setExpression(PrimaryExpressionNode expression)
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
     * Gets the name of the field.
     * @return The name of the field.
     */
    public IdentifierNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the name of the field.
     * @param identifier The name of the field.
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
        list.add(this.identifier);
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
        sb.append("identifier=");
        sb.append(this.identifier == null? "null" : this.identifier.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
