package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents an alternate constructor invocation, as in
 * <pre>
 * this("foo")
 * </pre>
 * Note that this only applies to <i>alternate</i> constructor invocations (those using the <tt>this</tt> keyword).
 * For superclass constructor invocations, see {@link SuperclassConstructorInvocationNode}.
 */
public interface AlternateConstructorInvocationNode extends ConstructorInvocationNode
{
}
