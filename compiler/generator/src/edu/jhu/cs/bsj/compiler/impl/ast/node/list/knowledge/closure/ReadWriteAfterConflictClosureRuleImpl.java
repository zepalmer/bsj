package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.AfterEffectKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.AfterInvariantKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.ConflictKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.RuleKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.TwoElementImmutableSet;

public class ReadWriteAfterConflictClosureRuleImpl extends AbstractBinaryKnowledgeClosureRule
{
	/** A singleton instance of this rule. */
	public static final ReadWriteAfterConflictClosureRuleImpl SINGLETON = new ReadWriteAfterConflictClosureRuleImpl();

	private ReadWriteAfterConflictClosureRuleImpl()
	{
		super(INVARIANT_LEFT + EXPR + ELEMENT_FOLLOWS + EXPR1 + INVARIANT_RIGHT + METAPROG + AND + EFFECT_LEFT + EXPR
				+ ELEMENT_FOLLOWS + EXPR2 + EFFECT_RIGHT + METAPROG2 + IMPLIES + CONTRADICTION);
	}

	@Override
	public <T extends Node> ListKnowledge<T> calculateClosure(ListKnowledge<T> termA, ListKnowledge<T> termB)
	{
		if (termA instanceof AfterInvariantKnowledge<?> && termB instanceof AfterEffectKnowledge<?>)
		{
			AfterInvariantKnowledge<T> afterInvariantKnowledge = (AfterInvariantKnowledge<T>) termA;
			AfterEffectKnowledge<T> afterEffectKnowledge = (AfterEffectKnowledge<T>) termB;
			if (afterInvariantKnowledge.getAnchor().equals(afterEffectKnowledge.getAnchor()))
			{
				return new ConflictKnowledgeImpl<T>(new RuleKnowledgeSourceImpl<T>(this,
						new TwoElementImmutableSet<ListKnowledge<T>>(termA, termB)));
			}
		}
		return null;
	}
}
