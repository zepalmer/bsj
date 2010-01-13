package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Acts as a parent to class instantiation nodes. 
 */
public interface ClassInstantiationNode extends Node, RestrictedPrimaryExpressionNode
{
    /**
     * Gets the type arguments for the constructor.
     * @return The type arguments for the constructor.
     */
    public ListNode<TypeNode> getConstructorTypeArguments();

    /**
     * Changes the type arguments for the constructor.
     * @param constructorTypeArguments The type arguments for the constructor.
     */
    public void setConstructorTypeArguments(ListNode<TypeNode> constructorTypeArguments);

    /**
     * Gets the arguments to the constructor.
     * @return The arguments to the constructor.
     */
    public ListNode<ExpressionNode> getArguments();

    /**
     * Changes the arguments to the constructor.
     * @param arguments The arguments to the constructor.
     */
    public void setArguments(ListNode<ExpressionNode> arguments);

    /**
     * Gets the body of the anonymous class.
     * @return The body of the anonymous class.
     */
    public AnonymousClassBodyNode getBody();

    /**
     * Changes the body of the anonymous class.
     * @param body The body of the anonymous class.
     */
    public void setBody(AnonymousClassBodyNode body);

}
