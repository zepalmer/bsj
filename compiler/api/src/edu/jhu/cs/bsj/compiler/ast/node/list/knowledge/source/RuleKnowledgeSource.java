package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source;

import java.util.Collection;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ClosureRule;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;

/**
 * Represents knowledge gained from a closure rule.
 * @author Zachary Palmer
 * @param <T> The type of element in the list containing the knowledge for which this object describes the source.
 */
public interface RuleKnowledgeSource<T extends Node> extends KnowledgeSource<T>
{
	/**
	 * Retrieves the closure rule that produced this knowledge.
	 * @return The rule in question.
	 */
	public ClosureRule getRule();
	
	/**
	 * Retrieves the knowledge units which were inputs to the closure rule.
	 * @return The closure rule inputs.
	 */
	public Collection<ListKnowledge<T>> getKnowledge();
}
