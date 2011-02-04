package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ContainmentEffectKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.PredicateKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ValueElement;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.ConflictKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.RuleKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.TwoElementImmutableSet;

public class PredicateCannotChangeClosureRuleImpl extends AbstractBinaryKnowledgeClosureRule
{
	/** A singleton instance of this rule. */
	public static final PredicateCannotChangeClosureRuleImpl SINGLETON = new PredicateCannotChangeClosureRuleImpl();

	private PredicateCannotChangeClosureRuleImpl()
	{
		super(INVARIANT_LEFT + PREDICATE + INVARIANT_RIGHT + METAPROG + AND + EFFECT_LEFT + EXPR + CONTAINMENT
				+ EFFECT_RIGHT + METAPROG2 + AND + PREDICATE + "(" + EXPR + ")" + IMPLIES + CONTRADICTION);
	}

	@Override
	public <T extends Node> ListKnowledge<T> calculateClosure(ListKnowledge<T> termA, ListKnowledge<T> termB)
	{
		if (termA instanceof PredicateKnowledge<?> && termB instanceof ContainmentEffectKnowledge<?>)
		{
			PredicateKnowledge<T> predicateKnowledge = (PredicateKnowledge<T>) termA;
			ContainmentEffectKnowledge<T> containmentEffectKnowledge = (ContainmentEffectKnowledge<T>) termB;
			if (containmentEffectKnowledge.getElement() instanceof ValueElement<?>)
			{
				ValueElement<T> element = (ValueElement<T>) containmentEffectKnowledge.getElement();
				// TODO: this filtering operation should record on behalf of the metaprogram that used the predicate,
				// not on the part of the metaprogram causing the invocation of this closure
				if (predicateKnowledge.getPredicate().filter(element.getData()))
				{
					return new ConflictKnowledgeImpl<T>(new RuleKnowledgeSourceImpl<T>(this,
							new TwoElementImmutableSet<ListKnowledge<T>>(termA, termB)));
				}
			}
		}
		return null;
	}
}
