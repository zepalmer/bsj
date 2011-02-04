package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ContainmentEffectKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.ConflictKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.RuleKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.TwoElementImmutableSet;

public class DualWriteConflictClosureRuleImpl extends AbstractBinaryKnowledgeClosureRule
{
	/** A singleton instance of this rule. */
	public static final DualWriteConflictClosureRuleImpl SINGLETON = new DualWriteConflictClosureRuleImpl();

	private DualWriteConflictClosureRuleImpl()
	{
		super(EFFECT_LEFT + EXPR + CONTAINMENT + EFFECT_RIGHT + METAPROG + AND + EFFECT_LEFT + EXPR + CONTAINMENT
				+ EFFECT_RIGHT + METAPROG2 + IMPLIES + CONTRADICTION);
	}

	@Override
	public <T extends Node> ListKnowledge<T> calculateClosure(ListKnowledge<T> termA, ListKnowledge<T> termB)
	{
		if (termA instanceof ContainmentEffectKnowledge<?> && termB instanceof ContainmentEffectKnowledge<?>)
		{
			ContainmentEffectKnowledge<T> termACasted = (ContainmentEffectKnowledge<T>)termA;
			ContainmentEffectKnowledge<T> termBCasted = (ContainmentEffectKnowledge<T>)termB;
			if (termACasted.getElement().equals(termBCasted.getElement()))
			{
				return new ConflictKnowledgeImpl<T>(new RuleKnowledgeSourceImpl<T>(this,
						new TwoElementImmutableSet<ListKnowledge<T>>(termA, termB)));
			}
		}
		return null;
	}
}
