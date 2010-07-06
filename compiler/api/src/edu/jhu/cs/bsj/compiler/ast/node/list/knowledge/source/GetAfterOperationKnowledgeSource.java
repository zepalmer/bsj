package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.SymbolicElement;

/**
 * Indicates that knowledge was derived from a get-after list operation.
 * @author Zachary Palmer
 *
 * @param <T> The type of data stored in the list to which this knowledge source pertains.
 */
public interface GetAfterOperationKnowledgeSource<T extends Node> extends OperationKnowledgeSource<T>
{
	/**
	 * Retrieves the anchor argument.
	 * @return The element after which another element was retrieved.
	 */
	public SymbolicElement<T> getAnchor();
	
	/**
	 * Retrieves the resulting element.
	 * @returnm The element which was retrieved from the list.
	 */
	public SymbolicElement<T> getResult();
}
