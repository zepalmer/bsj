package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.*;

import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.BeforeInvariantKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.AfterInvariantKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.RuleKnowledgeSourceImpl;

public class InvariantBeforeIsAfterClosureRuleImpl extends AbstractUnaryKnowledgeClosureRule
{
	/** A singleton instance of this rule. */
	public static final InvariantBeforeIsAfterClosureRuleImpl SINGLETON = new InvariantBeforeIsAfterClosureRuleImpl();

	private InvariantBeforeIsAfterClosureRuleImpl()
	{
		super(INVARIANT_LEFT + EXPR_PRIME + ELEMENT_LEADS + EXPR + INVARIANT_RIGHT + IMPLIES + INVARIANT_LEFT
				+ EXPR_PRIME + ELEMENT_FOLLOWS + EXPR + INVARIANT_RIGHT);
	}

	@Override
	public <T extends Node> ListKnowledge<T> calculateClosure(ListKnowledge<T> term)
	{
		if (term instanceof BeforeInvariantKnowledge<?>)
		{
			BeforeInvariantKnowledge<T> beforeInvariantKnowledge = (BeforeInvariantKnowledge<T>) term;
			return new AfterInvariantKnowledgeImpl<T>(beforeInvariantKnowledge.getMetaprogramId(),
					beforeInvariantKnowledge.getMetaprogramLocation(), new RuleKnowledgeSourceImpl<T>(this,
							Collections.singleton(term)), beforeInvariantKnowledge.getRelative(),
					beforeInvariantKnowledge.getAnchor());
		}
		return null;
	}
}
