package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents knowledge gained from a rule.
 * @author Zachary Palmer
 * @param <T> The type of element in the list containing the knowledge for which this object describes the source.
 */
public interface OperationKnowledgeSource<T extends Node> extends KnowledgeSource<T>
{
	/**
	 * Retrieves the stack trace at which the operation took place.
	 */
	public List<StackTraceElement> getStackTrace();
}
