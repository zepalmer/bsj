package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.AfterInvariantKnowledge;

public class InvariantAfterIsNewInvariantInClosureRuleImpl extends AbstractInvariantKnowledgeIsNewInvariantInClosureRule
{
	/** A singleton instance of this rule. */
	public static final InvariantAfterIsNewInvariantInClosureRuleImpl SINGLETON = new InvariantAfterIsNewInvariantInClosureRuleImpl();

	private InvariantAfterIsNewInvariantInClosureRuleImpl()
	{
		super(INVARIANT_LEFT + EXPR_PRIME + ELEMENT_FOLLOWS + EXPR + INVARIANT_RIGHT + IMPLIES + INVARIANT_LEFT + EXPR
				+ CONTAINMENT + INVARIANT_RIGHT, AfterInvariantKnowledge.class);
	}
}
