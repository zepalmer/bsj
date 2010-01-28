package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node representing method invocation by name, as in:
 * <pre>
 * <i>ambiguousName</i>.&lt;<i>typeArgs</i>&gt;<i>identifier</i>(<i>arg...</i>)
 * </pre>
 * or
 * <pre>
 * <i>methodName</i>(<i>arg...</i>)
 * </pre>
 * This node is used for simple method calls (such as <tt>x.y()</tt>) and not for expression-based method calls
 * (such as <tt>x().y()</tt>).  For expression-based method calls, see {@link MethodInvocationByExpressionNode}.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MethodInvocationByNameNode extends MethodInvocationNode
{
    /**
     * Gets the name of the method to invoke.
     * @return The name of the method to invoke.
     */
    public NameNode getName();

    /**
     * Changes the name of the method to invoke.
     * @param name The name of the method to invoke.
     */
    public void setName(NameNode name);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MethodInvocationByNameNode deepCopy(BsjNodeFactory factory);
}
