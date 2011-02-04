package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.AfterEffectKnowledge;

public class NothingAddedAfterEndClosureRuleImpl extends AbstractNothingAfterEndClosureRule
{
	/** A singleton instance of this rule. */
	public static final NothingAddedAfterEndClosureRuleImpl SINGLETON = new NothingAddedAfterEndClosureRuleImpl();

	private NothingAddedAfterEndClosureRuleImpl()
	{
		super(EFFECT_LEFT + LIST_END_SYMBOL + ELEMENT_FOLLOWS + EXPR + EFFECT_RIGHT + IMPLIES + CONTRADICTION,
				AfterEffectKnowledge.class);
	}
}
