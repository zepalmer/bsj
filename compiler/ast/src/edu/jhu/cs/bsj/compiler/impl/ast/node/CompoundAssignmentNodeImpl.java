package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.CompoundAssignmentNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;

public class CompoundAssignmentNodeImpl extends ExpressionNodeImpl implements CompoundAssignmentNode
{
    /** The expression to assign. */
    private ExpressionNode expression;

    /** The variable to which assignment is occurring. */
    private NameNode variable;

    /** General constructor. */
    public CompoundAssignmentNodeImpl(
            ExpressionNode expression,
            NameNode variable)
    {
        super();
        this.expression = expression;
        this.variable = variable;
    }

    /**
     * Gets the expression to assign.
     * @return The expression to assign.
     */
    public ExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes the expression to assign.
     * @param expression The expression to assign.
     */
    public void setExpression(ExpressionNode expression)
    {
        this.expression = expression;
    }

    /**
     * Gets the variable to which assignment is occurring.
     * @return The variable to which assignment is occurring.
     */
    public NameNode getVariable()
    {
        return this.variable;
    }

    /**
     * Changes the variable to which assignment is occurring.
     * @param variable The variable to which assignment is occurring.
     */
    public void setVariable(NameNode variable)
    {
        this.variable = variable;
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
