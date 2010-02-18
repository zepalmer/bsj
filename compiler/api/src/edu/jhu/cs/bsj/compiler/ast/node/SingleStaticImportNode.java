package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node representing a single static import statement, such as "<tt>import static java.util.Arrays.asList</tt>".
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface SingleStaticImportNode extends Node, ImportNode
{
    /**
     * Gets the name of the type from which to import.
     * @return The name of the type from which to import.
     */
    public NameNode getName();

    /**
     * Changes the name of the type from which to import.
     * @param name The name of the type from which to import.
     */
    public void setName(NameNode name);

    /**
     * Gets the identifier to import from that type.
     * @return The identifier to import from that type.
     */
    public IdentifierNode getIdentifier();

    /**
     * Changes the identifier to import from that type.
     * @param identifier The identifier to import from that type.
     */
    public void setIdentifier(IdentifierNode identifier);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SingleStaticImportNode deepCopy(BsjNodeFactory factory);
}
