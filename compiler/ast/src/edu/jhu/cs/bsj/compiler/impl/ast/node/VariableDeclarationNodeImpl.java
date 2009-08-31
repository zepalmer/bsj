package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;

public class VariableDeclarationNodeImpl extends StatementNodeImpl implements VariableDeclarationNode
{
    /** The variable to declare. */
    private VariableNode variable;

    /** The initializer to use. */
    private ExpressionNode initializer;

    /** General constructor. */
    public VariableDeclarationNodeImpl(
            VariableNode variable,
            ExpressionNode initializer)
    {
        super();
        this.variable = variable;
        this.initializer = initializer;
    }

    /**
     * Gets the variable to declare.
     * @return The variable to declare.
     */
    public VariableNode getVariable()
    {
        return this.variable;
    }

    /**
     * Changes the variable to declare.
     * @param variable The variable to declare.
     */
    public void setVariable(VariableNode variable)
    {
        this.variable = variable;
    }

    /**
     * Gets the initializer to use.
     * @return The initializer to use.
     */
    public ExpressionNode getInitializer()
    {
        return this.initializer;
    }

    /**
     * Changes the initializer to use.
     * @param initializer The initializer to use.
     */
    public void setInitializer(ExpressionNode initializer)
    {
        this.initializer = initializer;
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
