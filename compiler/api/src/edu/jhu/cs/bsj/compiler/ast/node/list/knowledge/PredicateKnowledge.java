package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents the knowledge that a predicate has been used on the list.
 * @param <T> The type of data stored in the list to which this knowledge pertains.
 */
public interface PredicateKnowledge<T extends Node> extends NullaryKnowledge<T>, InvariantKnowledge<T>
{
	/**
	 * Retrieves the predicate which was used to filter the list.
	 * @return The predicate which was used.
	 */
	public NodeFilter<? super T> getPredicate();
}
