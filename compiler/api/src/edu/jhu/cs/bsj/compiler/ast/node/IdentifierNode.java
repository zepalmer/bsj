package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.Identifier;

/**
 * A tree node representing a simple identifier, as in:
 * <pre>
 * <i>name</i>
 * </pre>
 */
public interface IdentifierNode extends NameNode
{
    /**
     * Gets the identifier contained in this node.
     * @return The identifier contained in this node.
     */
    public Identifier getIdentifier();

    /**
     * Changes the identifier contained in this node.
     * @param identifier The identifier contained in this node.
     */
    public void setIdentifier(Identifier identifier);

}
