package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.BeforeEffectKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.BeforeInvariantKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.ConflictKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.RuleKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.TwoElementImmutableSet;

public class ReadWriteBeforeConflictClosureRuleImpl extends AbstractBinaryKnowledgeClosureRule
{
	/** A singleton instance of this rule. */
	public static final ReadWriteBeforeConflictClosureRuleImpl SINGLETON = new ReadWriteBeforeConflictClosureRuleImpl();

	private ReadWriteBeforeConflictClosureRuleImpl()
	{
		super(INVARIANT_LEFT + EXPR1 + ELEMENT_LEADS + EXPR + INVARIANT_RIGHT + METAPROG + AND + EFFECT_LEFT
				+ EXPR2 + ELEMENT_LEADS + EXPR + EFFECT_RIGHT + METAPROG2 + IMPLIES + CONTRADICTION);
	}

	@Override
	public <T extends Node> ListKnowledge<T> calculateClosure(ListKnowledge<T> termA, ListKnowledge<T> termB)
	{
		if (termA instanceof BeforeInvariantKnowledge<?> && termB instanceof BeforeEffectKnowledge<?>)
		{
			BeforeInvariantKnowledge<T> beforeInvariantKnowledge = (BeforeInvariantKnowledge<T>) termA;
			BeforeEffectKnowledge<T> beforeEffectKnowledge = (BeforeEffectKnowledge<T>) termB;
			if (beforeInvariantKnowledge.getAnchor().equals(beforeEffectKnowledge.getAnchor()))
			{
				return new ConflictKnowledgeImpl<T>(new RuleKnowledgeSourceImpl<T>(this,
						new TwoElementImmutableSet<ListKnowledge<T>>(termA, termB)));
			}
		}
		return null;
	}
}
