package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
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
     * @throws ClassCastException If the value of this property is a special node.
     */
    public MetaprogramNode getMetaprogram()throws ClassCastException;
    
    /**
     * Gets the union object for the metaprogram on this node.
     * @return A union object representing The metaprogram on this node.
     */
    public NodeUnion<? extends MetaprogramNode> getUnionForMetaprogram();
    
    /**
     * Changes the metaprogram on this node.
     * @param metaprogram The metaprogram on this node.
     */
    public void setMetaprogram(MetaprogramNode metaprogram);
    
    /**
     * Changes the metaprogram on this node.
     * @param metaprogram The metaprogram on this node.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForMetaprogram(NodeUnion<? extends MetaprogramNode> metaprogram) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ExplicitMetaprogramAnchorNode<T> deepCopy(BsjNodeFactory factory);
    
}
