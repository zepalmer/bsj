package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents knowledge which concerns two elements from the list.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of data stored in the list to which this knowledge pertains.
 */
public interface BinaryKnowledge<T extends Node> extends SingleMetaprogramListKnowledge<T>
{
	/**
	 * Retrieves the first element in the knowledge.
	 * 
	 * @return The first element.
	 */
	public SymbolicElement<T> getFirst();

	/**
	 * Retrieves the second element in the knowledge.
	 * 
	 * @return The second element.
	 */
	public SymbolicElement<T> getSecond();
}
