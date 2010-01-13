package edu.jhu.cs.bsj.compiler.ast.node;

import java.util.List;

/**
 * Represents a list of nodes.  Nodes do not simply have lists as properties as the ListNode allows additional
 * information to be tracked as necessary.
 */
public interface ListNode<T extends Node> extends Node
{
    /**
     * Gets the list of children.
     * @return The list of children.
     */
    public List<T> getChildren();

}
