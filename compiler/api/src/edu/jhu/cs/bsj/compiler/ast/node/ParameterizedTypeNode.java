package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.BoundType;
import edu.jhu.cs.bsj.compiler.ast.tags.ParameterizableType;
import edu.jhu.cs.bsj.compiler.ast.tags.TypeArgument;

/**
 * A node representing a type parameterization as in:
 * <pre>
 * <i>type</i> &lt;<i>arg...</i>&gt;
 * </pre>
 */
public interface ParameterizedTypeNode extends TypeNode, TypeArgument,  BoundType
{
    /**
     * Gets the base to parameterize.
     * @return The base to parameterize.
     */
    public ParameterizableType getBaseType();

    /**
     * Changes the base to parameterize.
     * @param baseType The base to parameterize.
     */
    public void setBaseType(ParameterizableType baseType);

    /**
     * Gets the parameterized type arguments.
     * @return The parameterized type arguments.
     */
    public ListNode<? extends TypeArgument> getTypeArguments();

    /**
     * Changes the parameterized type arguments.
     * @param typeArguments The parameterized type arguments.
     */
    public void setTypeArguments(ListNode<? extends TypeArgument> typeArguments);

}
