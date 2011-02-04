package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.*;

import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.AfterEffectKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.ContainmentEffectKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.RuleKnowledgeSourceImpl;

public class EffectAfterIsNewEffectInClosureRuleImpl extends AbstractUnaryKnowledgeClosureRule
{
	/** A singleton instance of this rule. */
	public static final EffectAfterIsNewEffectInClosureRuleImpl SINGLETON = new EffectAfterIsNewEffectInClosureRuleImpl();

	private EffectAfterIsNewEffectInClosureRuleImpl()
	{
		super(EFFECT_LEFT + EXPR_PRIME + ELEMENT_FOLLOWS + EXPR + EFFECT_RIGHT + IMPLIES + EFFECT_LEFT + EXPR
				+ CONTAINMENT + EFFECT_RIGHT);
	}

	@Override
	public <T extends Node> ListKnowledge<T> calculateClosure(ListKnowledge<T> term)
	{
		if (term instanceof AfterEffectKnowledge<?>)
		{
			AfterEffectKnowledge<T> afterEffectKnowledge = (AfterEffectKnowledge<T>) term;
			return new ContainmentEffectKnowledgeImpl<T>(afterEffectKnowledge.getMetaprogramId(),
					afterEffectKnowledge.getMetaprogramLocation(), new RuleKnowledgeSourceImpl<T>(this,
							Collections.singleton(term)), afterEffectKnowledge.getRelative());
		}
		return null;
	}
}
