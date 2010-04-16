package edu.jhu.cs.bsj.compiler.ast;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Specifies a node filtering predicate.  This interface is used in conjunction with {@link NodeList} to retrieve
 * elements from a {@link NodeList} which match a certain condition.  This is safer than iterating through the list in
 * order to locate the values because it provides the access conflict detection system with a more precise understanding
 * of what information the calling metaprogram actually needs.  That is, using this approach instead of iteration will
 * prevent false positives in conflict detection.
 * <p/>
 * Implementations of this filter <b>must</b> operate deterministically; given a specific node, an implementation of
 * this filter is required to return the same result for multiple successive calls.  This means that implementations of
 * this filter should not access global state or other such resources to make their decisions unless the global state is
 * known to be constant.
 * <p/>
 * Implementations of this filter are forbidden to modify the AST when they are making their determinations.
 * 
 * @author Zachary Palmer
 * @param <T> The type of node handled by this filter.
 */
public interface NodeFilter<T extends Node>
{
	/**
	 * Filters the specified node by the criteria of this filter.
	 * @param node The node to filter.
	 * @return <code>true</code> if the node meets the criteria of this filter; <code>false</code> if it does not.
	 */
	public boolean filter(T node);
}
