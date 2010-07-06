package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.NodeList;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.KnowledgeSource;

/**
 * Represents a piece of conflict detection knowledge obtained by a {@link NodeList}.
 * @author Zachary Palmer
 * @param <T> The type of element for the list which contains this knowledge.
 */
public interface ListKnowledge<T extends Node>
{
	/**
	 * Retrieves an object representing the source of this knowledge.
	 * @return The source of this knowledge.
	 */
	public KnowledgeSource<T> getKnowledgeSource();
}