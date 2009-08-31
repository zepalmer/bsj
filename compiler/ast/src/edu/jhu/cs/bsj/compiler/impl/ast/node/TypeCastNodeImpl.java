package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeCastNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

public class TypeCastNodeImpl extends ExpressionNodeImpl implements TypeCastNode
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
        this.expression = expression;
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
        this.type = type;
    }

    /**
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
