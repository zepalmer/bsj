package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing parameterized types.  This node represents the use of a type which has type arguments, such
 * as Set<String> (which would be represented by the raw type Set and the single-element argument list containing
 * the raw type for String).
 */
public interface ParameterizedTypeNode extends Node, DeclaredTypeNode
{
    /**
     * Gets the raw type being parameterized.
     * @return The raw type being parameterized.
     */
    public RawTypeNode getRawType();

    /**
     * Changes the raw type being parameterized.
     * @param rawType The raw type being parameterized.
     */
    public void setRawType(RawTypeNode rawType);

    /**
     * Gets the type arguments for this node.
     * @return The type arguments for this node.
     */
    public ListNode<TypeArgument> getTypeArguments();

    /**
     * Changes the type arguments for this node.
     * @param typeArguments The type arguments for this node.
     */
    public void setTypeArguments(ListNode<TypeArgument> typeArguments);

}
