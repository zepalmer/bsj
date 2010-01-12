package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

public class ClassInstantiationNodeImpl extends RestrictedPrimaryExpressionNodeImpl implements ClassInstantiationNode
{
    /** The type arguments of the instantiation. */
    private ListNode<? extends TypeNode> typeArguments;

    /** The type being instantiated. */
    private DeclaredTypeNode type;

    /** The arguments to the constructor. */
    private ListNode<? extends ExpressionNode> arguments;

    /** The body of the anonymous class. */
    private AnonymousClassBodyNode body;

    /** The expression enclosing the non-static inner class. */
    private ExpressionNode enclosingExpression;

    /** General constructor. */
    public ClassInstantiationNodeImpl(
            ListNode<? extends TypeNode> typeArguments,
            DeclaredTypeNode type,
            ListNode<? extends ExpressionNode> arguments,
            AnonymousClassBodyNode body,
            ExpressionNode enclosingExpression)
    {
        super();
        this.typeArguments = typeArguments;
        this.type = type;
        this.arguments = arguments;
        this.body = body;
        this.enclosingExpression = enclosingExpression;
    }

    /**
     * Gets the type arguments of the instantiation.
     * @return The type arguments of the instantiation.
     */
    public ListNode<? extends TypeNode> getTypeArguments()
    {
        return this.typeArguments;
    }

    /**
     * Changes the type arguments of the instantiation.
     * @param typeArguments The type arguments of the instantiation.
     */
    public void setTypeArguments(ListNode<? extends TypeNode> typeArguments)
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
     * Gets the type being instantiated.
     * @return The type being instantiated.
     */
    public DeclaredTypeNode getType()
    {
        return this.type;
    }

    /**
     * Changes the type being instantiated.
     * @param type The type being instantiated.
     */
    public void setType(DeclaredTypeNode type)
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
     * Gets the arguments to the constructor.
     * @return The arguments to the constructor.
     */
    public ListNode<? extends ExpressionNode> getArguments()
    {
        return this.arguments;
    }

    /**
     * Changes the arguments to the constructor.
     * @param arguments The arguments to the constructor.
     */
    public void setArguments(ListNode<? extends ExpressionNode> arguments)
    {
        if (this.arguments instanceof NodeImpl)
        {
            ((NodeImpl)this.arguments).setParent(null);
        }
        this.arguments = arguments;
        if (this.arguments instanceof NodeImpl)
        {
            ((NodeImpl)this.arguments).setParent(this);
        }
    }

    /**
     * Gets the body of the anonymous class.
     * @return The body of the anonymous class.
     */
    public AnonymousClassBodyNode getBody()
    {
        return this.body;
    }

    /**
     * Changes the body of the anonymous class.
     * @param body The body of the anonymous class.
     */
    public void setBody(AnonymousClassBodyNode body)
    {
        if (this.body instanceof NodeImpl)
        {
            ((NodeImpl)this.body).setParent(null);
        }
        this.body = body;
        if (this.body instanceof NodeImpl)
        {
            ((NodeImpl)this.body).setParent(this);
        }
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
        this.typeArguments.receive(visitor);
        this.type.receive(visitor);
        this.arguments.receive(visitor);
        this.body.receive(visitor);
        this.enclosingExpression.receive(visitor);
    }
}
