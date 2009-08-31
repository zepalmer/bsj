package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.InstanceOfNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

public class InstanceOfNodeImpl extends ExpressionNodeImpl implements InstanceOfNode
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
        this.expression = expression;
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
