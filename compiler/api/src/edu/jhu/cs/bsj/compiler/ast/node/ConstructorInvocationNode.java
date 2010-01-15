package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * This class is a common superclass to both types of explicit constructor invocations: alternate constructor
 * invocations (those using the <tt>this</tt> keyword) and superclass constructor invocations (those using the
 * <tt>super</tt> keyword).  This distinction is made because, despite their similarities in use and syntax, the
 * language specification treats these two entities as distinct (and there are some corner cases for the superclass
 * constructor syntax which are best contained
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
public interface ConstructorInvocationNode extends Node
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
