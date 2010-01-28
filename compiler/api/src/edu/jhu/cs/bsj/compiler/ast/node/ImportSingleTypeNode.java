package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node representing a single type import statement, such as "<tt>import java.util.Set</tt>".
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ImportSingleTypeNode extends Node, ImportNode
{
    /**
     * Gets the name of the type to import.
     * @return The name of the type to import.
     */
    public NameNode getName();

    /**
     * Changes the name of the type to import.
     * @param name The name of the type to import.
     */
    public void setName(NameNode name);

    /**
     * Gets the static-ness of the import.
     * @return The static-ness of the import.
     */
    public boolean getStaticImport();

    /**
     * Changes the static-ness of the import.
     * @param staticImport The static-ness of the import.
     */
    public void setStaticImport(boolean staticImport);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ImportSingleTypeNode deepCopy(BsjNodeFactory factory);
}
