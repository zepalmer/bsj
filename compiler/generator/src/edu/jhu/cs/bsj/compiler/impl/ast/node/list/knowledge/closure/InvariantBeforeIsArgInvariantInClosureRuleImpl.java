package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.CONTAINMENT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.ELEMENT_LEADS;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EXPR;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EXPR_PRIME;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.IMPLIES;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.INVARIANT_LEFT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.INVARIANT_RIGHT;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.BeforeInvariantKnowledge;

public class InvariantBeforeIsArgInvariantInClosureRuleImpl extends AbstractRelativeKnowledgeIsArgInvariantInClosureRule
{
	/** A singleton instance of this rule. */
	public static final InvariantBeforeIsArgInvariantInClosureRuleImpl SINGLETON = new InvariantBeforeIsArgInvariantInClosureRuleImpl();

	private InvariantBeforeIsArgInvariantInClosureRuleImpl()
	{
		super(INVARIANT_LEFT + EXPR + ELEMENT_LEADS + EXPR_PRIME + INVARIANT_RIGHT + IMPLIES + INVARIANT_LEFT + EXPR_PRIME
				+ CONTAINMENT + INVARIANT_RIGHT, BeforeInvariantKnowledge.class);
	}
}
