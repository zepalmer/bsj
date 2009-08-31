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
        if (this.variable instanceof NodeImpl)
        {
            ((NodeImpl)this.variable).setParent(null);
        }
        this.variable = variable;
        if (this.variable instanceof NodeImpl)
        {
            ((NodeImpl)this.variable).setParent(this);
        }
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
        if (this.initializer instanceof NodeImpl)
        {
            ((NodeImpl)this.initializer).setParent(null);
        }
        this.initializer = initializer;
        if (this.initializer instanceof NodeImpl)
        {
            ((NodeImpl)this.initializer).setParent(this);
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
        this.variable.receive(visitor);
        this.initializer.receive(visitor);
    }
}
