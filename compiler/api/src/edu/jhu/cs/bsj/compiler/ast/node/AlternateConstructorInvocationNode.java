package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

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
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AlternateConstructorInvocationNode deepCopy(BsjNodeFactory factory);
    
}
