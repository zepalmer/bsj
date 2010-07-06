package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.BinaryRelativeKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.ContainmentInvariantKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.RuleKnowledgeSourceImpl;

/**
 * This abstract class serves to contain the logic for all relative knowledge rules implying that the anchor is an
 * invariant for the metaprogram that uses it. For instance, knowing that e follows e' implies that you know that e' was
 * in the list before you asked the question.
 */
public abstract class AbstractRelativeKnowledgeIsArgInvariantInClosureRule extends AbstractUnaryKnowledgeClosureRule
{
	/** The class of knowledge on which to operate. */
	private Class<? extends BinaryRelativeKnowledge<?>> clazz;

	public <T extends BinaryRelativeKnowledge<?>> AbstractRelativeKnowledgeIsArgInvariantInClosureRule(
			String description, Class<T> clazz)
	{
		super(description);
		this.clazz = clazz;
	}

	@Override
	public <T extends Node> ListKnowledge<T> calculateClosure(ListKnowledge<T> term)
	{
		if (this.clazz.isInstance(term))
		{
			BinaryRelativeKnowledge<T> binaryRelativeKnowledge = (BinaryRelativeKnowledge<T>) term;
			return new ContainmentInvariantKnowledgeImpl<T>(binaryRelativeKnowledge.getMetaprogramId(),
					binaryRelativeKnowledge.getMetaprogramLocation(), new RuleKnowledgeSourceImpl<T>(this,
							Collections.singleton(term)), binaryRelativeKnowledge.getAnchor());
		}
		return null;
	}
}
