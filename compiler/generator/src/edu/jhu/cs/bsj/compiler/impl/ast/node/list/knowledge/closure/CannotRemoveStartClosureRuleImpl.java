package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.*;

import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ContainmentEffectKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.StartElement;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.ConflictKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.RuleKnowledgeSourceImpl;

public class CannotRemoveStartClosureRuleImpl extends AbstractUnaryKnowledgeClosureRule
{
	/** A singleton instance of this rule. */
	public static final CannotRemoveStartClosureRuleImpl SINGLETON = new CannotRemoveStartClosureRuleImpl();

	private CannotRemoveStartClosureRuleImpl()
	{
		super(EFFECT_LEFT + LIST_START_SYMBOL + CONTAINMENT + EFFECT_RIGHT + IMPLIES + CONTRADICTION);
	}

	@Override
	public <T extends Node> ListKnowledge<T> calculateClosure(ListKnowledge<T> term)
	{
		if (term instanceof ContainmentEffectKnowledge<?>)
		{
			ContainmentEffectKnowledge<T> containmentEffectKnowledge = (ContainmentEffectKnowledge<T>) term;
			if (containmentEffectKnowledge.getElement() instanceof StartElement<?>)
			{
				return new ConflictKnowledgeImpl<T>(new RuleKnowledgeSourceImpl<T>(this, Collections.singleton(term)));
			}
		}
		return null;
	}
}
