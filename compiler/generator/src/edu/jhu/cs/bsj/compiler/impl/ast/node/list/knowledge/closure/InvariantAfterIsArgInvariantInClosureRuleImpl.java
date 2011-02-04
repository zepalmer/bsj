package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.AfterInvariantKnowledge;

public class InvariantAfterIsArgInvariantInClosureRuleImpl extends AbstractRelativeKnowledgeIsArgInvariantInClosureRule
{
	/** A singleton instance of this rule. */
	public static final InvariantAfterIsArgInvariantInClosureRuleImpl SINGLETON = new InvariantAfterIsArgInvariantInClosureRuleImpl();

	private InvariantAfterIsArgInvariantInClosureRuleImpl()
	{
		super(INVARIANT_LEFT + EXPR_PRIME + ELEMENT_FOLLOWS + EXPR + INVARIANT_RIGHT + IMPLIES + INVARIANT_LEFT + EXPR_PRIME
				+ CONTAINMENT + INVARIANT_RIGHT, AfterInvariantKnowledge.class);
	}
}
