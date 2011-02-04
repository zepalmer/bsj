package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.BeforeEffectKnowledge;

public class DualWriteBeforeConflictClosureRuleImpl extends AbstractDualWriteConflictClosureRule
{
	/** A singleton instance of this rule. */
	public static final DualWriteBeforeConflictClosureRuleImpl SINGLETON = new DualWriteBeforeConflictClosureRuleImpl();

	private DualWriteBeforeConflictClosureRuleImpl()
	{
		super(EFFECT_LEFT + EXPR1 + ELEMENT_LEADS + EXPR + EFFECT_RIGHT + METAPROG + AND + EFFECT_LEFT + EXPR2
				+ ELEMENT_LEADS + EXPR + EFFECT_RIGHT + METAPROG2 + AND + ORDER_LEFT + EXPR1 + ORDER_SEPARATOR + EXPR2
				+ ORDER_RIGHT + IMPLIES + CONTRADICTION,
				BeforeEffectKnowledge.class);
	}
}
