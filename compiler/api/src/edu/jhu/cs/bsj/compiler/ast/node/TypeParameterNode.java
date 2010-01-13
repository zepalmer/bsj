package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node for type parameters, as in:
 * <pre>
 * <i>ident</i>
 * </pre>
 * or
 * <pre>
 * <i>ident</i> extends <i>type</i>
 * </pre>
 * or
 * <pre>
 * <i>ident</i> extends <i>type</i> &amp; <i>type...</i>
 * </pre>
 */
public interface TypeParameterNode extends Node
{
    /**
     * Gets the base type name for the parameter.
     * @return The base type name for the parameter.
     */
    public IdentifierNode getIdentifier();

    /**
     * Changes the base type name for the parameter.
     * @param identifier The base type name for the parameter.
     */
    public void setIdentifier(IdentifierNode identifier);

    /**
     * Gets the bounds over the base type.
     * @return The bounds over the base type.
     */
    public ListNode<DeclaredTypeNode> getBounds();

    /**
     * Changes the bounds over the base type.
     * @param bounds The bounds over the base type.
     */
    public void setBounds(ListNode<DeclaredTypeNode> bounds);

}
