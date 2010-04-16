package edu.jhu.cs.bsj.compiler.ast;

import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * This interface specifies basic list operations for a node containing an ordered set of other nodes.
 * 
 * @author Zachary Palmer
 * @param <T> The type of node contained in the list.
 */
public interface NodeList<T extends Node>
{
	/**
	 * Inserts the provided node to the beginning of the list.
	 * 
	 * @param node The node to add.
	 * @throws NullPointerException If <code>node</code> is <code>null</code>.
	 */
	public void addFirst(T node);

	/**
	 * Inserts the provided node at the end of the list.
	 * 
	 * @param node The node to add.
	 * @throws Exception If <code>node</code> is <code>null</code>.
	 */
	public void addLast(T node);

	/**
	 * Inserts the provided node into the list immediately before the specified node.
	 * 
	 * @param member The node which is already a member of this list.
	 * @param node The node to add.
	 * @throws IllegalArgumentException If the provided <code>member</code> is not a member of this list.
	 * @throws NullPointerException If either <code>member</code> or <code>node</code> is <code>null</code>.
	 */
	public void addBefore(T member, T node) throws IllegalArgumentException;

	/**
	 * Inserts the provided node into the list immediately after the specified node.
	 * 
	 * @param member The node which is already a member of this list.
	 * @param node The node to add.
	 * @throws IllegalArgumentException If the provided <code>member</code> is not a member of this list.
	 * @throws NullPointerException If either <code>member</code> or <code>node</code> is <code>null</code>.
	 */
	public void addAfter(T member, T node) throws IllegalArgumentException;

	/**
	 * Removes the provided node from this list. If the node was not already a member of this list, the list is
	 * unchanged.
	 * 
	 * @param node The node to remove.
	 * @return <code>true</code> if that value existed in this list; <code>false</code> if it did not.
	 * @throws NullPointerException If <code>node</code> is <code>null</code>.
	 */
	public boolean remove(T node);

	/**
	 * Retrieves the node which appears at the beginning of the list.
	 * 
	 * @return The node which appears at the beginning of the list or <code>null</code> if the list is empty.
	 */
	public T getFirst();

	/**
	 * Retrieves the node which appears at the end of the list.
	 * 
	 * @return The node which appears at the end of the list or <code>null</code> if the list is empty.
	 */
	public T getLast();

	/**
	 * Retrieves the node which appears before the specified node in the list.
	 * 
	 * @param member The member for which we desire the preceeding node.
	 * @return The node which appears before that member or <code>null</code> if that member is first in the list.
	 * @throws IllegalArgumentException If the specified <code>member</code> is not a member in this list.
	 * @throws NullPointerException If <code>member</code> is <code>null</code>.
	 */
	public T getBefore(T member) throws IllegalArgumentException;

	/**
	 * Retrieves the node which appears after the specified node in the list.
	 * 
	 * @param member The member for which we desire the succeeding node.
	 * @return The node which appears before that member or <code>null</code> if that member is last in the list.
	 * @throws IllegalArgumentException If the specified <code>member</code> is not a member in this list.
	 * @throws NullPointerException If <code>member</code> is <code>null</code>.
	 */
	public T getAfter(T member) throws IllegalArgumentException;

	/**
	 * Retrieves all members of this list which meet the criteria of the specified node filter.
	 * 
	 * @param filter The filter to use.
	 * @return All members contained in this list which meet the criteria of the specified node filter. Note that the
	 *         return value is a set; its contents are in no particular order and probably do not reflect the order of
	 *         the members in this list.
	 */
	public Set<T> filter(NodeFilter<? super T> filter);
}
