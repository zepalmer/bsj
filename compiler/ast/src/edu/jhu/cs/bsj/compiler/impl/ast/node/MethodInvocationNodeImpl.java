package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

public class MethodInvocationNodeImpl extends ExpressionNodeImpl implements MethodInvocationNode
{
    /** The selection obtaining the method to invoke. */
    private NameNode methodSelect;

    /** The arguments to pass to the method. */
    private ListNode<? extends ExpressionNode> arguments;

    /** The type arguments for the method. */
    private ListNode<? extends TypeNode> typeArguments;

    /** General constructor. */
    public MethodInvocationNodeImpl(
            NameNode methodSelect,
            ListNode<? extends ExpressionNode> arguments,
            ListNode<? extends TypeNode> typeArguments)
    {
        super();
        this.methodSelect = methodSelect;
        this.arguments = arguments;
        this.typeArguments = typeArguments;
    }

    /**
     * Gets the selection obtaining the method to invoke.
     * @return The selection obtaining the method to invoke.
     */
    public NameNode getMethodSelect()
    {
        return this.methodSelect;
    }

    /**
     * Changes the selection obtaining the method to invoke.
     * @param methodSelect The selection obtaining the method to invoke.
     */
    public void setMethodSelect(NameNode methodSelect)
    {
        if (this.methodSelect instanceof NodeImpl)
        {
            ((NodeImpl)this.methodSelect).setParent(null);
        }
        this.methodSelect = methodSelect;
        if (this.methodSelect instanceof NodeImpl)
        {
            ((NodeImpl)this.methodSelect).setParent(this);
        }
    }

    /**
     * Gets the arguments to pass to the method.
     * @return The arguments to pass to the method.
     */
    public ListNode<? extends ExpressionNode> getArguments()
    {
        return this.arguments;
    }

    /**
     * Changes the arguments to pass to the method.
     * @param arguments The arguments to pass to the method.
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
     * Gets the type arguments for the method.
     * @return The type arguments for the method.
     */
    public ListNode<? extends TypeNode> getTypeArguments()
    {
        return this.typeArguments;
    }

    /**
     * Changes the type arguments for the method.
     * @param typeArguments The type arguments for the method.
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
        this.methodSelect.receive(visitor);
        this.arguments.receive(visitor);
        this.typeArguments.receive(visitor);
    }
}