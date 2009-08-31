package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing method invocation, as in:
 * <pre>
 * <i>expr</i>.&lt;<i>typeArgs</i>&gt;<i>identifier</i>(<i>arg...</i>)
 * </pre>
 */
public interface MethodInvocationNode extends ExpressionNode
{
    /**
     * Gets the selection obtaining the method to invoke.
     * @return The selection obtaining the method to invoke.
     */
    public NameNode getMethodSelect();

    /**
     * Changes the selection obtaining the method to invoke.
     * @param methodSelect The selection obtaining the method to invoke.
     */
    public void setMethodSelect(NameNode methodSelect);

    /**
     * Gets the arguments to pass to the method.
     * @return The arguments to pass to the method.
     */
    public ListNode<? extends ExpressionNode> getArguments();

    /**
     * Changes the arguments to pass to the method.
     * @param arguments The arguments to pass to the method.
     */
    public void setArguments(ListNode<? extends ExpressionNode> arguments);

    /**
     * Gets the type arguments for the method.
     * @return The type arguments for the method.
     */
    public ListNode<? extends TypeNode> getTypeArguments();

    /**
     * Changes the type arguments for the method.
     * @param typeArguments The type arguments for the method.
     */
    public void setTypeArguments(ListNode<? extends TypeNode> typeArguments);

}
