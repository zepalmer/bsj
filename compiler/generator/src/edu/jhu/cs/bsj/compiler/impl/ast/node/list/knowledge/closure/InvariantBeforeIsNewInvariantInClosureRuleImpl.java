package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.*;

import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.BeforeInvariantKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.ContainmentInvariantKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.RuleKnowledgeSourceImpl;

public class InvariantBeforeIsNewInvariantInClosureRuleImpl extends AbstractInvariantKnowledgeIsNewInvariantInClosureRule
{
	/** A singleton instance of this rule. */
	public static final InvariantBeforeIsNewInvariantInClosureRuleImpl SINGLETON = new InvariantBeforeIsNewInvariantInClosureRuleImpl();

	private InvariantBeforeIsNewInvariantInClosureRuleImpl()
	{
		super(INVARIANT_LEFT + EXPR + ELEMENT_LEADS + EXPR_PRIME + INVARIANT_RIGHT + IMPLIES + INVARIANT_LEFT + EXPR
				+ CONTAINMENT + INVARIANT_RIGHT, BeforeInvariantKnowledge.class);
	}

	@Override
	public <T extends Node> ListKnowledge<T> calculateClosure(ListKnowledge<T> term)
	{
		if (term instanceof BeforeInvariantKnowledge<?>)
		{
			BeforeInvariantKnowledge<T> beforeInvariantKnowledge = (BeforeInvariantKnowledge<T>) term;
			return new ContainmentInvariantKnowledgeImpl<T>(beforeInvariantKnowledge.getMetaprogramId(),
					beforeInvariantKnowledge.getMetaprogramLocation(), new RuleKnowledgeSourceImpl<T>(this,
							Collections.singleton(term)), beforeInvariantKnowledge.getRelative());
		}
		return null;
	}
}
