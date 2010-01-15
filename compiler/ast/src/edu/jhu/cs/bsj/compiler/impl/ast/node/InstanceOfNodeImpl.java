package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.InstanceOfNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

public class InstanceOfNodeImpl extends NodeImpl implements InstanceOfNode
{
    /** The expression being evaluated. */
    private ExpressionNode expression;

    /** The type being checked. */
    private TypeNode type;

    /** General constructor. */
    public InstanceOfNodeImpl(
            ExpressionNode expression,
            TypeNode type)
    {
        super();
        this.expression = expression;
        this.type = type;
    }

    /**
     * Gets the expression being evaluated.
     * @return The expression being evaluated.
     */
    public ExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes the expression being evaluated.
     * @param expression The expression being evaluated.
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
     * Gets the type being checked.
     * @return The type being checked.
     */
    public TypeNode getType()
    {
        return this.type;
    }

    /**
     * Changes the type being checked.
     * @param type The type being checked.
     */
    public void setType(TypeNode type)
    {
        if (this.type instanceof NodeImpl)
        {
            ((NodeImpl)this.type).setParent(null);
        }
        this.type = type;
        if (this.type instanceof NodeImpl)
        {
            ((NodeImpl)this.type).setParent(this);
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
        this.type.receive(visitor);
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
        list.add(this.type);
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
        sb.append("type=");
        sb.append(this.type == null? "null" : this.type.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
