package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.IdentifierListNode;

/**
 * Represents a metaprogram target declaration, as in
 * <pre>
 * #target target;
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramTargetNode extends Node, BsjSpecificNode
{
    /**
     * Gets the names of the metaprogram targets in which to participate.
     * @return The names of the metaprogram targets in which to participate.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierListNode getTargets()throws ClassCastException;
    
    /**
     * Gets the union object for the names of the metaprogram targets in which to participate.
     * @return A union object representing The names of the metaprogram targets in which to participate.
     */
    public NodeUnion<? extends IdentifierListNode> getUnionForTargets();
    
    /**
     * Changes the names of the metaprogram targets in which to participate.
     * @param targets The names of the metaprogram targets in which to participate.
     */
    public void setTargets(IdentifierListNode targets);
    
    /**
     * Changes the names of the metaprogram targets in which to participate.
     * @param targets The names of the metaprogram targets in which to participate.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForTargets(NodeUnion<? extends IdentifierListNode> targets) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramTargetNode deepCopy(BsjNodeFactory factory);
    
}
