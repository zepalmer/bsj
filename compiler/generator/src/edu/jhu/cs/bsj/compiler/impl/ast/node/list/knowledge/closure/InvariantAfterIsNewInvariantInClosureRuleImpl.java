package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.CONTAINMENT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.ELEMENT_FOLLOWS;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EXPR;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EXPR_PRIME;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.IMPLIES;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.INVARIANT_LEFT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.INVARIANT_RIGHT;
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
