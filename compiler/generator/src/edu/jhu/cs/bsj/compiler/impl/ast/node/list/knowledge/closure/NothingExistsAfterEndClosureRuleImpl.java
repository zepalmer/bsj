package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.CONTRADICTION;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.ELEMENT_FOLLOWS;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EXPR;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.IMPLIES;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.INVARIANT_LEFT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.INVARIANT_RIGHT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.LIST_END_SYMBOL;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.AfterInvariantKnowledge;

public class NothingExistsAfterEndClosureRuleImpl extends AbstractNothingAfterEndClosureRule
{
	/** A singleton instance of this rule. */
	public static final NothingExistsAfterEndClosureRuleImpl SINGLETON = new NothingExistsAfterEndClosureRuleImpl();

	private NothingExistsAfterEndClosureRuleImpl()
	{
		super(INVARIANT_LEFT + LIST_END_SYMBOL + ELEMENT_FOLLOWS + EXPR + INVARIANT_RIGHT + IMPLIES + CONTRADICTION,
				AfterInvariantKnowledge.class);
	}
}
