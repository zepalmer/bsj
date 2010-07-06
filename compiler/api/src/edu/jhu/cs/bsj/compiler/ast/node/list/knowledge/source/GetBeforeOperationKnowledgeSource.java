package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.SymbolicElement;

/**
 * Indicates that knowledge was derived from a get-before list operation.
 * @author Zachary Palmer
 *
 * @param <T> The type of data stored in the list to which this knowledge source pertains.
 */
public interface GetBeforeOperationKnowledgeSource<T extends Node> extends OperationKnowledgeSource<T>
{
	/**
	 * Retrieves the anchor argument.
	 * @return The element before which another element was retrieved.
	 */
	public SymbolicElement<T> getAnchor();
	
	/**
	 * Retrieves the resulting element.
	 * @returnm The element which was retrieved before the anchor argument.
	 */
	public SymbolicElement<T> getResult();
}
