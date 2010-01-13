package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing method invocation by expression, as in:
 * <pre>
 * <i>expr</i>.&lt;<i>typeArgs</i>&gt;<i>identifier</i>(<i>arg...</i>)
 * </pre>
 * For example, this node might be used when an expression produces an object against which we want to call a
 * method as in
 * <pre>
 * new Object().toString()
 * </pre>
 * or
 * <pre>
 * foo().bar()
 * </pre>
 * For simple method invocations (such as <tt>myObjectReference.myMethod()</tt>), see
 * {@link MethodInvocationByNameNode}.
 */
public interface MethodInvocationByExpressionNode extends MethodInvocationNode
{
    /**
     * Gets the expression against which to invoke the method.
     * @return The expression against which to invoke the method.
     */
    public PrimaryExpressionNode getExpression();

    /**
     * Changes the expression against which to invoke the method.
     * @param expression The expression against which to invoke the method.
     */
    public void setExpression(PrimaryExpressionNode expression);

    /**
     * Gets the name of the method to invoke.
     * @return The name of the method to invoke.
     */
    public IdentifierNode getIdentifier();

    /**
     * Changes the name of the method to invoke.
     * @param identifier The name of the method to invoke.
     */
    public void setIdentifier(IdentifierNode identifier);

}
