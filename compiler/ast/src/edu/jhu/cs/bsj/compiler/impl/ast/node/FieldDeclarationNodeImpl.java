package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;

public class FieldDeclarationNodeImpl extends NodeImpl implements FieldDeclarationNode
{
    /** The variable description of the field. */
    private VariableNode variable;

    /** The initializer to use. */
    private ExpressionNode initializer;

    /** General constructor. */
    public FieldDeclarationNodeImpl(
            VariableNode variable,
            ExpressionNode initializer)
    {
        super();
        this.variable = variable;
        this.initializer = initializer;
    }

    /**
     * Gets the variable description of the field.
     * @return The variable description of the field.
     */
    public VariableNode getVariable()
    {
        return this.variable;
    }

    /**
     * Changes the variable description of the field.
     * @param variable The variable description of the field.
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
