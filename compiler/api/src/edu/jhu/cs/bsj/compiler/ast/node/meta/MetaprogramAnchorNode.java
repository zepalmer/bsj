package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents the anchor for a metaprogram during its execution.  The replacement field on this node is
 * used to indicate the node with which this node will be replaced once the execution of this metaprogram
 * terminates.  This is initially defaulted to a no-op.  If the replacement field is <tt>null</tt>, no
 * replacement occurs.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramAnchorNode<T extends Node> extends Node, BsjSpecificNode
{
    /**
     * Gets the type of node which can replace this anchor.
     * @return The type of node which can replace this anchor.
     */
    public Class<T> getReplacementType();
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramAnchorNode<T> deepCopy(BsjNodeFactory factory);
    
	/**
	 * Creates a node which is suitable as a default replacement for this node.
	 * @param factory The node factory to use.
	 * @return A suitable default replacement for this node.
	 */
	public T getDefaultReplacement(BsjNodeFactory factory);
}
