package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeCastNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
public class TypeCastNodeImpl extends NodeImpl implements TypeCastNode
{
    /** The expression to cast. */
    private ExpressionNode expression;

    /** The type to which to cast. */
    private TypeNode type;

    /** General constructor. */
    public TypeCastNodeImpl(
            ExpressionNode expression,
            TypeNode type)
    {
        super();
        this.expression = expression;
        this.type = type;
    }

    /**
     * Gets the expression to cast.
     * @return The expression to cast.
     */
    public ExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes the expression to cast.
     * @param expression The expression to cast.
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
     * Gets the type to which to cast.
     * @return The type to which to cast.
     */
    public TypeNode getType()
    {
        return this.type;
    }

    /**
     * Changes the type to which to cast.
     * @param type The type to which to cast.
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
