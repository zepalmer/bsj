package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * Acts as a parent to class instantiation nodes. 
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ClassInstantiationNode extends Node, RestrictedPrimaryExpressionNode,  StatementExpressionNode
{
    /**
     * Gets the type arguments for the constructor.
     * @return The type arguments for the constructor.
     */
    public ListNode<TypeArgumentNode> getConstructorTypeArguments();

    /**
     * Changes the type arguments for the constructor.
     * @param constructorTypeArguments The type arguments for the constructor.
     */
    public void setConstructorTypeArguments(ListNode<TypeArgumentNode> constructorTypeArguments);

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
