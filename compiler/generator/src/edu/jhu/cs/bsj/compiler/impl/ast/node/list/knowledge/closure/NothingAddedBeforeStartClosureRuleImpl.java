package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.BeforeEffectKnowledge;

public class NothingAddedBeforeStartClosureRuleImpl extends AbstractNothingBeforeStartClosureRule
{
	/** A singleton instance of this rule. */
	public static final NothingAddedBeforeStartClosureRuleImpl SINGLETON = new NothingAddedBeforeStartClosureRuleImpl();

	private NothingAddedBeforeStartClosureRuleImpl()
	{
		super(EFFECT_LEFT + EXPR + ELEMENT_LEADS + LIST_START_SYMBOL + EFFECT_RIGHT + IMPLIES + CONTRADICTION,
				BeforeEffectKnowledge.class);
	}
}
