package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ClosureRule;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;

/**
 * This interface is implemented by those closure rules which require two knowledge terms.
 * 
 * @author Zachary Palmer
 */
public interface BinaryKnowledgeClosureRule extends ClosureRule
{
	/**
	 * Calculates the closure of the provided knowledge terms.  It is assumed that the provided terms' metaprograms
	 * do not cooperate.
	 * 
	 * @param termA The first input knowledge term.
	 * @param termB The second input knowledge term.
	 * @return A new term to add to the knowledge or <code>null</code> if no new knowledge is gathered.
	 */
	public <T extends Node> ListKnowledge<T> calculateClosure(ListKnowledge<T> termA, ListKnowledge<T> termB);
}
