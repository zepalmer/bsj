package edu.jhu.cs.bsj.compiler.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ExplicitMetaprogramAnchorNode;

/**
 * The type of context used by explicit metaprograms.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of anchor node for this context.
 * @param <U> The type of node which can replace the anchor in this context.
 */
public interface ExplicitContext<T extends ExplicitMetaprogramAnchorNode<U>, U extends Node> extends Context<T, U>
{
    /**
     * A convenience method which adds the provided node before the anchor in the list in which the anchor appears.
     * 
     * @param node The node to add.
     * @throws NullPointerException If the provided node is <code>null</code> or if the anchor has been removed from its
     *             list.
     * @throws ClassCastException If the anchor has a parent which is not a list.
     */
    public void addBefore(U node);

    /**
     * A convenience method which adds the provided node after the anchor in the list in which the anchor appears.
     * 
     * @param node The node to add.
     * @throws NullPointerException If the provided node is <code>null</code> or if the anchor has been removed from its
     *             list.
     * @throws ClassCastException If the anchor has a parent which is not a list.
     */
    public void addAfter(U node);

    /**
     * Retrieves the list in which the anchor appears.
     * 
     * @return The list containing the anchor.
     * @throws NullPointerException If the anchor has been removed from its list.
     * @throws ClassCastException If the anchor has a parent which is not a list or which is a list of a type different
     *             from that in which it was originally positioned.
     */
    public ListNode<U> getPeers();
}
