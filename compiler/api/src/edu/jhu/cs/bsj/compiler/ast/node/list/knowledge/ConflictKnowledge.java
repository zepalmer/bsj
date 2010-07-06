package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.RuleKnowledgeSource;

/**
 * Represents knowledge of a conflict.
 * @author Zachary Palmer
 *
 * @param <T> The type of data stored in the list to which this knowledge pertains.
 */
public interface ConflictKnowledge<T extends Node> extends ListKnowledge<T>
{
	/**
	 * Retrieves an object representing the source of this knowledge.
	 * @return The source of this knowledge.
	 */
	public RuleKnowledgeSource<T> getKnowledgeSource();
}
