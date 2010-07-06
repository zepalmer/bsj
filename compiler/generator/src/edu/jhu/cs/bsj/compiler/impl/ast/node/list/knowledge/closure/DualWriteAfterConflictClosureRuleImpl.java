package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.AND;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.CONTRADICTION;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EFFECT_LEFT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EFFECT_RIGHT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.ELEMENT_FOLLOWS;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EXPR;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EXPR1;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EXPR2;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.IMPLIES;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.METAPROG;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.METAPROG2;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.ORDER_LEFT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.ORDER_RIGHT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.ORDER_SEPARATOR;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.AfterEffectKnowledge;

public class DualWriteAfterConflictClosureRuleImpl extends AbstractDualWriteConflictClosureRule
{
	/** A singleton instance of this rule. */
	public static final DualWriteAfterConflictClosureRuleImpl SINGLETON = new DualWriteAfterConflictClosureRuleImpl();

	private DualWriteAfterConflictClosureRuleImpl()
	{
		super(EFFECT_LEFT + EXPR + ELEMENT_FOLLOWS + EXPR1 + EFFECT_RIGHT + METAPROG + AND + EFFECT_LEFT + EXPR
				+ ELEMENT_FOLLOWS + EXPR2 + EFFECT_RIGHT + METAPROG2 + AND + ORDER_LEFT + EXPR1 + ORDER_SEPARATOR
				+ EXPR2 + ORDER_RIGHT + IMPLIES + CONTRADICTION,
				AfterEffectKnowledge.class);
	}
}
