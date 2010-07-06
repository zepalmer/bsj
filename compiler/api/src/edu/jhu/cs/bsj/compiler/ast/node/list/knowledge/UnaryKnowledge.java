package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents list knowledge which concerns a single element from the list.
 * @author Zachary Palmer
 *
 * @param <T> The type of data stored in the list to which this knowledge pertains.
 */
public interface UnaryKnowledge<T extends Node> extends SingleMetaprogramListKnowledge<T>
{
	/**
	 * Retrieves the element from this knowledge unit.
	 * @return The element to which this knowledge applies.
	 */
	public SymbolicElement<T> getElement();
}
