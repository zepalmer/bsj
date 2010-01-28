package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

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
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
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

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SuperclassConstructorInvocationNode deepCopy(BsjNodeFactory factory);
}
