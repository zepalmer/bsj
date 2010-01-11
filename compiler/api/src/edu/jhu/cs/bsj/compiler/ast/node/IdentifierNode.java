package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A tree node representing a simple identifier, as in:
 * <pre>
 * <i>ident</i>
 * </pre>
 */
public interface IdentifierNode extends Node
{
    /**
     * Gets the identifier contained in this node.
     * @return The identifier contained in this node.
     */
    public String getIdentifier();

    /**
     * Changes the identifier contained in this node.
     * @param identifier The identifier contained in this node.
     */
    public void setIdentifier(String identifier);

}
