package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeArgumentNode;

public abstract class ClassInstantiationNodeImpl extends NodeImpl implements ClassInstantiationNode
{
    /** The type arguments for the constructor. */
    private ListNode<TypeArgumentNode> constructorTypeArguments;

    /** The arguments to the constructor. */
    private ListNode<ExpressionNode> arguments;

    /** The body of the anonymous class. */
    private AnonymousClassBodyNode body;

    /** General constructor. */
    protected ClassInstantiationNodeImpl(
            ListNode<TypeArgumentNode> constructorTypeArguments,
            ListNode<ExpressionNode> arguments,
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
    public ListNode<TypeArgumentNode> getConstructorTypeArguments()
    {
        return this.constructorTypeArguments;
    }

    /**
     * Changes the type arguments for the constructor.
     * @param constructorTypeArguments The type arguments for the constructor.
     */
    public void setConstructorTypeArguments(ListNode<TypeArgumentNode> constructorTypeArguments)
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
    public ListNode<ExpressionNode> getArguments()
    {
        return this.arguments;
    }

    /**
     * Changes the arguments to the constructor.
     * @param arguments The arguments to the constructor.
     */
    public void setArguments(ListNode<ExpressionNode> arguments)
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

    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(this.constructorTypeArguments);
        list.add(this.arguments);
        list.add(this.body);
        return list;
    }

    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('[');
        sb.append("constructorTypeArguments=");
        sb.append(this.constructorTypeArguments == null? "null" : this.constructorTypeArguments.getClass().getSimpleName());
        sb.append(',');
        sb.append("arguments=");
        sb.append(this.arguments == null? "null" : this.arguments.getClass().getSimpleName());
        sb.append(',');
        sb.append("body=");
        sb.append(this.body == null? "null" : this.body.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
