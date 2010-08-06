package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents an anchor node for an explicit metaprogram (one declared using the <tt>[: :]</tt>
 * delimiters).  <tt>metaprogram</tt> may be <tt>null</tt> if the metaprogram has already been extracted
 * and prepared for execution by the compiler.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ExplicitMetaprogramAnchorNode<T extends Node> extends MetaprogramAnchorNode<T>, BsjSpecificNode
{
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
    public ExplicitMetaprogramAnchorNode<T> deepCopy(BsjNodeFactory factory);
}
