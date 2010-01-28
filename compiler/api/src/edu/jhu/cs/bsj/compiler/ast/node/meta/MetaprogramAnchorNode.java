package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * The replacement field on this node is used to indicate the node with which this node will be replaced once the
 * execution of this metaprogram terminates.  This is initially defaulted to a no-op.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramAnchorNode<T extends Node> extends Node
{
    /**
     * Gets the replacement node for this metaprogram.
     * @return The replacement node for this metaprogram.
     */
    public T getReplacement();

    /**
     * Gets the metaprogram on this node.
     * @return The metaprogram on this node.
     */
    public MetaprogramNode getMetaprogram();

    /**
     * Changes the metaprogram on this node.
     * @param metaprogram The metaprogram on this node.
     */
    public void setMetaprogram(MetaprogramNode metaprogram);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramAnchorNode<T> deepCopy(BsjNodeFactory factory);
}
