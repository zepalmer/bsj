package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.BeforeInvariantKnowledge;

public class NothingExistsBeforeStartClosureRuleImpl extends AbstractNothingBeforeStartClosureRule
{
	/** A singleton instance of this rule. */
	public static final NothingExistsBeforeStartClosureRuleImpl SINGLETON = new NothingExistsBeforeStartClosureRuleImpl();

	private NothingExistsBeforeStartClosureRuleImpl()
	{
		super(INVARIANT_LEFT + EXPR + ELEMENT_LEADS + LIST_START_SYMBOL + INVARIANT_RIGHT + IMPLIES + CONTRADICTION,
				BeforeInvariantKnowledge.class);
	}
}
