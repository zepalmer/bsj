package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing parameterized types.  This node represents the use of a type which has type arguments, such
 * as Set<String> (which would be represented by the unparameterized type Set and the single-element argument list
 * containing the unparameterized type for String).
 */
public interface ParameterizedTypeNode extends Node, DeclaredTypeNode
{
    /**
     * Gets the base type being parameterized.
     * @return The base type being parameterized.
     */
    public UnparameterizedTypeNode getBaseType();

    /**
     * Changes the base type being parameterized.
     * @param baseType The base type being parameterized.
     */
    public void setBaseType(UnparameterizedTypeNode baseType);

    /**
     * Gets the type arguments for this node.
     * @return The type arguments for this node.
     */
    public ListNode<TypeArgumentNode> getTypeArguments();

    /**
     * Changes the type arguments for this node.
     * @param typeArguments The type arguments for this node.
     */
    public void setTypeArguments(ListNode<TypeArgumentNode> typeArguments);

}
