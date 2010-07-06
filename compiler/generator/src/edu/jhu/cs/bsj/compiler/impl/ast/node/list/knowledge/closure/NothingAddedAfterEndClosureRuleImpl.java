package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.CONTRADICTION;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EFFECT_LEFT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EFFECT_RIGHT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.ELEMENT_FOLLOWS;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EXPR;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.IMPLIES;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.LIST_END_SYMBOL;
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
