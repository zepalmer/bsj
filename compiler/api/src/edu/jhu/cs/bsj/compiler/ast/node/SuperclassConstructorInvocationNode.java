package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents an alternate constructor invocation, as in
 * <pre>
 * super("foo")
 * </pre>
 * or in the rarer syntax
 * <pre>
 * (new Foo()).super(0)
 * </pre>
 * .  Note that this only applies to <i>superclass</i> constructor invocations (those using the <tt>super</tt>
 * keyword).  For alternate constructor invocations, see {@link AlternateConstructorInvocationNode}.
 */
public interface SuperclassConstructorInvocationNode extends ConstructorInvocationNode
{
    /**
     * Gets the qualifying expression for the enclosing object.
     * @return The qualifying expression for the enclosing object.
     */
    public PrimaryExpressionNode getQualifyingExpression();

    /**
     * Changes the qualifying expression for the enclosing object.
     * @param qualifyingExpression The qualifying expression for the enclosing object.
     */
    public void setQualifyingExpression(PrimaryExpressionNode qualifyingExpression);

}
