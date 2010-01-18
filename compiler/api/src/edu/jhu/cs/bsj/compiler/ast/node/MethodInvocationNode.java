package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A superclass for method invocation nodes.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MethodInvocationNode extends Node, RestrictedPrimaryExpressionNode,  StatementExpressionNode
{
    /**
     * Gets the arguments to pass to the method.
     * @return The arguments to pass to the method.
     */
    public ListNode<ExpressionNode> getArguments();

    /**
     * Changes the arguments to pass to the method.
     * @param arguments The arguments to pass to the method.
     */
    public void setArguments(ListNode<ExpressionNode> arguments);

    /**
     * Gets the type arguments for the method.
     * @return The type arguments for the method.
     */
    public ListNode<TypeNode> getTypeArguments();

    /**
     * Changes the type arguments for the method.
     * @param typeArguments The type arguments for the method.
     */
    public void setTypeArguments(ListNode<TypeNode> typeArguments);

}
