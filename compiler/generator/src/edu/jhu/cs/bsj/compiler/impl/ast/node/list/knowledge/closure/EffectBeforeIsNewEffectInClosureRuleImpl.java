package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.CONTAINMENT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EFFECT_LEFT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EFFECT_RIGHT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.ELEMENT_LEADS;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EXPR;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EXPR_PRIME;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.IMPLIES;

import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.BeforeEffectKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.ContainmentEffectKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.RuleKnowledgeSourceImpl;

public class EffectBeforeIsNewEffectInClosureRuleImpl extends AbstractUnaryKnowledgeClosureRule
{
	/** A singleton instance of this rule. */
	public static final EffectBeforeIsNewEffectInClosureRuleImpl SINGLETON = new EffectBeforeIsNewEffectInClosureRuleImpl();

	private EffectBeforeIsNewEffectInClosureRuleImpl()
	{
		super(EFFECT_LEFT + EXPR + ELEMENT_LEADS + EXPR_PRIME + EFFECT_RIGHT + IMPLIES + EFFECT_LEFT + EXPR
				+ CONTAINMENT + EFFECT_RIGHT);
	}

	@Override
	public <T extends Node> ListKnowledge<T> calculateClosure(ListKnowledge<T> term)
	{
		if (term instanceof BeforeEffectKnowledge<?>)
		{
			BeforeEffectKnowledge<T> beforeEffectKnowledge = (BeforeEffectKnowledge<T>)term;
			return new ContainmentEffectKnowledgeImpl<T>(beforeEffectKnowledge.getMetaprogramId(),
					beforeEffectKnowledge.getMetaprogramLocation(), new RuleKnowledgeSourceImpl<T>(this,
							Collections.singleton(term)), beforeEffectKnowledge.getRelative());
		}
		return null;
	}
}
