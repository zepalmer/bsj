package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.BoundType;
import edu.jhu.cs.bsj.compiler.ast.tags.TypeArgument;

/**
 * A node expressing a parameterized type, as in:
 * <pre>
 * <i>type</i> &lt;<i>arg...</i>&gt;
 * </pre>
 */
public interface ParameterizedTypeNode extends TypeNode, TypeArgument,  BoundType
{
    /**
     * Gets the base type.
     * @return The base type.
     */
    public DeclaredTypeNode getType();

    /**
     * Changes the base type.
     * @param type The base type.
     */
    public void setType(DeclaredTypeNode type);

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
