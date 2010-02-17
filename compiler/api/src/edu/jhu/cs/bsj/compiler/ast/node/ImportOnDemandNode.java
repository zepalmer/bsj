package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node representing an on-demand import statement, such as "<tt>import java.util.*</tt>".
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ImportOnDemandNode extends Node, ImportNode
{
    /**
     * Gets the name of the package to import.
     * @return The name of the package to import.
     */
    public NameNode getName();

    /**
     * Changes the name of the package to import.
     * @param name The name of the package to import.
     */
    public void setName(NameNode name);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ImportOnDemandNode deepCopy(BsjNodeFactory factory);
}
