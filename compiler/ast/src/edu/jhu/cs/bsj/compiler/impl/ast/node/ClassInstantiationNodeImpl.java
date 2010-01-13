package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

public abstract class ClassInstantiationNodeImpl extends NodeImpl implements ClassInstantiationNode
{
    /** The type arguments for the constructor. */
    private ListNode<? extends TypeNode> constructorTypeArguments;

    /** The arguments to the constructor. */
    private ListNode<? extends ExpressionNode> arguments;

    /** The body of the anonymous class. */
    private AnonymousClassBodyNode body;

    /** General constructor. */
    protected ClassInstantiationNodeImpl(
            ListNode<? extends TypeNode> constructorTypeArguments,
            ListNode<? extends ExpressionNode> arguments,
            AnonymousClassBodyNode body)
    {
        super();
        this.constructorTypeArguments = constructorTypeArguments;
        this.arguments = arguments;
        this.body = body;
    }

    /**
     * Gets the type arguments for the constructor.
     * @return The type arguments for the constructor.
     */
    public ListNode<? extends TypeNode> getConstructorTypeArguments()
    {
        return this.constructorTypeArguments;
    }

    /**
     * Changes the type arguments for the constructor.
     * @param constructorTypeArguments The type arguments for the constructor.
     */
    public void setConstructorTypeArguments(ListNode<? extends TypeNode> constructorTypeArguments)
    {
        if (this.constructorTypeArguments instanceof NodeImpl)
        {
            ((NodeImpl)this.constructorTypeArguments).setParent(null);
        }
        this.constructorTypeArguments = constructorTypeArguments;
        if (this.constructorTypeArguments instanceof NodeImpl)
        {
            ((NodeImpl)this.constructorTypeArguments).setParent(this);
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
        this.constructorTypeArguments.receive(visitor);
        this.arguments.receive(visitor);
        this.body.receive(visitor);
    }
}
