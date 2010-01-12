package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.NameExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;

public class NameExpressionNodeImpl extends ExpressionNodeImpl implements NameExpressionNode
{
    /** The name to evaluate for this expression. */
    private NameNode name;

    /** General constructor. */
    public NameExpressionNodeImpl(
            NameNode name)
    {
        super();
        this.name = name;
    }

    /**
     * Gets the name to evaluate for this expression.
     * @return The name to evaluate for this expression.
     */
    public NameNode getName()
    {
        return this.name;
    }

    /**
     * Changes the name to evaluate for this expression.
     * @param name The name to evaluate for this expression.
     */
    public void setName(NameNode name)
    {
        if (this.name instanceof NodeImpl)
        {
            ((NodeImpl)this.name).setParent(null);
        }
        this.name = name;
        if (this.name instanceof NodeImpl)
        {
            ((NodeImpl)this.name).setParent(this);
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
        this.name.receive(visitor);
    }
}
