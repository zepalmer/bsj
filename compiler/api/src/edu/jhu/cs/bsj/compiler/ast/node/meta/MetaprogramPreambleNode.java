package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * This node represents a metaprogram's preamble.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramPreambleNode extends Node
{
    /**
     * Gets the imports for this metaprogram.
     * @return The imports for this metaprogram.
     */
    public MetaprogramImportListNode getImports();

    /**
     * Changes the imports for this metaprogram.
     * @param imports The imports for this metaprogram.
     */
    public void setImports(MetaprogramImportListNode imports);

    /**
     * Gets the targets for this metaprogram.
     * @return The targets for this metaprogram.
     */
    public MetaprogramTargetNode getTarget();

    /**
     * Changes the targets for this metaprogram.
     * @param target The targets for this metaprogram.
     */
    public void setTarget(MetaprogramTargetNode target);

    /**
     * Gets the dependencies for this metaprogram.
     * @return The dependencies for this metaprogram.
     */
    public MetaprogramDependsNode getDepends();

    /**
     * Changes the dependencies for this metaprogram.
     * @param depends The dependencies for this metaprogram.
     */
    public void setDepends(MetaprogramDependsNode depends);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramPreambleNode deepCopy(BsjNodeFactory factory);
}
