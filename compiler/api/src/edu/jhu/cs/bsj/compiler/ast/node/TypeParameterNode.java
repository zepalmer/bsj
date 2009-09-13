package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.BoundType;

/**
 * A node for type parameters, as in:
 * <pre>
 * <i>name</i>
 * </pre>
 * or
 * <pre>
 * <i>name</i> extends <i>type</i>
 * </pre>
 * or
 * <pre>
 * <i>name</i> extends <i>type</i> &amp; <i>type...</i>
 * </pre>
 */
public interface TypeParameterNode extends Node
{
    /**
     * Gets the base type name for the parameter.
     * @return The base type name for the parameter.
     */
    public IdentifierNode getName();

    /**
     * Changes the base type name for the parameter.
     * @param name The base type name for the parameter.
     */
    public void setName(IdentifierNode name);

    /**
     * Gets the bounds over the base type.
     * @return The bounds over the base type.
     */
    public ListNode<? extends BoundType> getBounds();

    /**
     * Changes the bounds over the base type.
     * @param bounds The bounds over the base type.
     */
    public void setBounds(ListNode<? extends BoundType> bounds);

}
