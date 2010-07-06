package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.SymbolicElement;

/**
 * Indicates that knowledge was derived from a remove list operation.
 * @author Zachary Palmer
 *
 * @param <T> The type of data stored in the list to which this knowledge source pertains.
 */
public interface RemoveOperationKnowledgeSource<T extends Node> extends OperationKnowledgeSource<T>
{
	/**
	 * Retrieves the element which was removed.
	 * @return The element which was removed.
	 */
	public SymbolicElement<T> getElement();
}
