package edu.jhu.cs.bsj.compiler.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a list of nodes.  Nodes do not simply have lists as properties as the ListNode allows additional
 * information to be tracked as necessary.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ListNode<T extends Node> extends Node
{
    /**
     * Gets the list of children.
     * @return The list of children.
     */
    public List<T> getChildren();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ListNode<T> deepCopy(BsjNodeFactory factory);
}
