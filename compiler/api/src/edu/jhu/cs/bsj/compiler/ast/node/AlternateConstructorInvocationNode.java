package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * Represents an alternate constructor invocation, as in
 * <pre>
 * this("foo")
 * </pre>
 * Note that this only applies to <i>alternate</i> constructor invocations (those using the <tt>this</tt> keyword).
 * For superclass constructor invocations, see {@link SuperclassConstructorInvocationNode}.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AlternateConstructorInvocationNode extends ConstructorInvocationNode
{
}
