package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.SuperclassConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

public class SuperclassConstructorInvocationNodeImpl extends ConstructorInvocationNodeImpl implements SuperclassConstructorInvocationNode
{
    /** The qualifying expression for the enclosing object. */
    private ExpressionNode qualifyingExpression;

    /** General constructor. */
    public SuperclassConstructorInvocationNodeImpl(
            ExpressionNode qualifyingExpression,
            ListNode<? extends ExpressionNode> arguments,
            ListNode<? extends TypeNode> typeArguments)
    {
        super(arguments, typeArguments);
        this.qualifyingExpression = qualifyingExpression;
    }

    /**
     * Gets the qualifying expression for the enclosing object.
     * @return The qualifying expression for the enclosing object.
     */
    public ExpressionNode getQualifyingExpression()
    {
        return this.qualifyingExpression;
    }

    /**
     * Changes the qualifying expression for the enclosing object.
     * @param qualifyingExpression The qualifying expression for the enclosing object.
     */
    public void setQualifyingExpression(ExpressionNode qualifyingExpression)
    {
        if (this.qualifyingExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.qualifyingExpression).setParent(null);
        }
        this.qualifyingExpression = qualifyingExpression;
        if (this.qualifyingExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.qualifyingExpression).setParent(this);
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
        this.qualifyingExpression.receive(visitor);
    }
}
