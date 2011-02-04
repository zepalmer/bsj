package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.BeforeEffectKnowledge;

public class EffectBeforeIsArgInvariantInClosureRuleImpl extends AbstractRelativeKnowledgeIsArgInvariantInClosureRule
{
	/** A singleton instance of this rule. */
	public static final EffectBeforeIsArgInvariantInClosureRuleImpl SINGLETON = new EffectBeforeIsArgInvariantInClosureRuleImpl();

	private EffectBeforeIsArgInvariantInClosureRuleImpl()
	{
		super(EFFECT_LEFT + EXPR + ELEMENT_LEADS + EXPR_PRIME + EFFECT_RIGHT + IMPLIES + INVARIANT_LEFT + EXPR
				+ CONTAINMENT + INVARIANT_RIGHT, BeforeEffectKnowledge.class);
	}
}
