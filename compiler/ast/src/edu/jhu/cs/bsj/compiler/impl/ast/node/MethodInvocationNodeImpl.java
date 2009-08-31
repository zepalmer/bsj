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
        this.methodSelect = methodSelect;
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
        this.arguments = arguments;
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
        this.typeArguments = typeArguments;
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
