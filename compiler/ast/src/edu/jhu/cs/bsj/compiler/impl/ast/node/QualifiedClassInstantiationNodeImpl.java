package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

public class QualifiedClassInstantiationNodeImpl extends ClassInstantiationNodeImpl implements QualifiedClassInstantiationNode
{
    /** The expression enclosing the non-static inner class. */
    private ExpressionNode enclosingExpression;

    /** The name of the class being instantiated. */
    private IdentifierNode identifier;

    /** The type arguments to apply to the class being instantiated. */
    private ListNode<TypeNode> typeArguments;

    /** General constructor. */
    public QualifiedClassInstantiationNodeImpl(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            ListNode<TypeNode> typeArguments,
            ListNode<TypeNode> constructorTypeArguments,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body)
    {
        super(constructorTypeArguments, arguments, body);
        this.enclosingExpression = enclosingExpression;
        this.identifier = identifier;
        this.typeArguments = typeArguments;
    }

    /**
     * Gets the expression enclosing the non-static inner class.
     * @return The expression enclosing the non-static inner class.
     */
    public ExpressionNode getEnclosingExpression()
    {
        return this.enclosingExpression;
    }

    /**
     * Changes the expression enclosing the non-static inner class.
     * @param enclosingExpression The expression enclosing the non-static inner class.
     */
    public void setEnclosingExpression(ExpressionNode enclosingExpression)
    {
        if (this.enclosingExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.enclosingExpression).setParent(null);
        }
        this.enclosingExpression = enclosingExpression;
        if (this.enclosingExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.enclosingExpression).setParent(this);
        }
    }

    /**
     * Gets the name of the class being instantiated.
     * @return The name of the class being instantiated.
     */
    public IdentifierNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the name of the class being instantiated.
     * @param identifier The name of the class being instantiated.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
        if (this.identifier instanceof NodeImpl)
        {
            ((NodeImpl)this.identifier).setParent(null);
        }
        this.identifier = identifier;
        if (this.identifier instanceof NodeImpl)
        {
            ((NodeImpl)this.identifier).setParent(this);
        }
    }

    /**
     * Gets the type arguments to apply to the class being instantiated.
     * @return The type arguments to apply to the class being instantiated.
     */
    public ListNode<TypeNode> getTypeArguments()
    {
        return this.typeArguments;
    }

    /**
     * Changes the type arguments to apply to the class being instantiated.
     * @param typeArguments The type arguments to apply to the class being instantiated.
     */
    public void setTypeArguments(ListNode<TypeNode> typeArguments)
    {
        if (this.typeArguments instanceof NodeImpl)
        {
            ((NodeImpl)this.typeArguments).setParent(null);
        }
        this.typeArguments = typeArguments;
        if (this.typeArguments instanceof NodeImpl)
        {
            ((NodeImpl)this.typeArguments).setParent(this);
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
        this.enclosingExpression.receive(visitor);
        this.identifier.receive(visitor);
        this.typeArguments.receive(visitor);
    }
}