package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node representing a static on-demand import statement, such as "<tt>import static java.util.Arrays.*</tt>".
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface StaticImportOnDemandNode extends Node, ImportNode
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
    public StaticImportOnDemandNode deepCopy(BsjNodeFactory factory);
    
}
