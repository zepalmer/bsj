package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A tree node representing a simple identifier, as in:
 * <pre>
 * <i>ident</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
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

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public IdentifierNode deepCopy(BsjNodeFactory factory);
}
