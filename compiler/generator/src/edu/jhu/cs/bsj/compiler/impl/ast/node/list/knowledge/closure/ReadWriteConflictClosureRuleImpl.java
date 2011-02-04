package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ContainmentEffectKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ContainmentInvariantKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.ConflictKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.RuleKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.TwoElementImmutableSet;

public class ReadWriteConflictClosureRuleImpl extends AbstractBinaryKnowledgeClosureRule
{
	/** A singleton instance of this rule. */
	public static final ReadWriteConflictClosureRuleImpl SINGLETON = new ReadWriteConflictClosureRuleImpl();

	private ReadWriteConflictClosureRuleImpl()
	{
		super(INVARIANT_LEFT + EXPR + CONTAINMENT + INVARIANT_RIGHT + METAPROG + AND + EFFECT_LEFT + EXPR + CONTAINMENT
				+ EFFECT_RIGHT + METAPROG2 + IMPLIES + CONTRADICTION);
	}

	@Override
	public <T extends Node> ListKnowledge<T> calculateClosure(ListKnowledge<T> termA, ListKnowledge<T> termB)
	{
		if (termA instanceof ContainmentInvariantKnowledge<?> && termB instanceof ContainmentEffectKnowledge<?>)
		{
			ContainmentInvariantKnowledge<T> containmentInvariantKnowledge = (ContainmentInvariantKnowledge<T>) termA;
			ContainmentEffectKnowledge<T> containmentEffectKnowledge = (ContainmentEffectKnowledge<T>) termB;
			if (containmentInvariantKnowledge.getElement().equals(containmentEffectKnowledge.getElement()))
			{
				return new ConflictKnowledgeImpl<T>(new RuleKnowledgeSourceImpl<T>(this,
						new TwoElementImmutableSet<ListKnowledge<T>>(termA, termB)));
			}
		}
		return null;
	}
}
