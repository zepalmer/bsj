package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.AfterEffectKnowledge;

public class EffectAfterIsArgInvariantInClosureRuleImpl extends AbstractRelativeKnowledgeIsArgInvariantInClosureRule
{
	/** A singleton instance of this rule. */
	public static final EffectAfterIsArgInvariantInClosureRuleImpl SINGLETON = new EffectAfterIsArgInvariantInClosureRuleImpl();

	private EffectAfterIsArgInvariantInClosureRuleImpl()
	{
		super(EFFECT_LEFT + EXPR_PRIME + ELEMENT_FOLLOWS + EXPR + EFFECT_RIGHT + IMPLIES + INVARIANT_LEFT + EXPR
				+ CONTAINMENT + INVARIANT_RIGHT, AfterEffectKnowledge.class);
	}
}
