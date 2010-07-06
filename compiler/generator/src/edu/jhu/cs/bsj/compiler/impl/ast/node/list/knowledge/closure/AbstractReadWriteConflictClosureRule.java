package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.BinaryRelativeKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.ConflictKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.RuleKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.TwoElementImmutableSet;

public abstract class AbstractReadWriteConflictClosureRule extends AbstractBinaryKnowledgeClosureRule
{
	private Class<? extends BinaryRelativeKnowledge<?>> clazz;

	public <T extends BinaryRelativeKnowledge<?>> AbstractReadWriteConflictClosureRule(String description,
			Class<T> clazz)
	{
		super(description);
		this.clazz = clazz;
	}

	@Override
	public <T extends Node> ListKnowledge<T> calculateClosure(ListKnowledge<T> termA, ListKnowledge<T> termB)
	{
		if (this.clazz.isInstance(termA) && this.clazz.isInstance(termB))
		{
			final BinaryRelativeKnowledge<T> castedA = (BinaryRelativeKnowledge<T>) termA;
			final BinaryRelativeKnowledge<T> castedB = (BinaryRelativeKnowledge<T>) termB;
			if (castedA.getAnchor().equals(castedB.getAnchor()))
			{
				return new ConflictKnowledgeImpl<T>(new RuleKnowledgeSourceImpl<T>(this,
						new TwoElementImmutableSet<ListKnowledge<T>>(termA, termB)));
			}
		}
		return null;
	}

}
