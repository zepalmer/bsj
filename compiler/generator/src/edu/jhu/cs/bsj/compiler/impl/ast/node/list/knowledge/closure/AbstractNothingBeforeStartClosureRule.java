package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.BeforeKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.StartElement;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.ConflictKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.RuleKnowledgeSourceImpl;

public abstract class AbstractNothingBeforeStartClosureRule extends AbstractUnaryKnowledgeClosureRule
{
	private Class<? extends BeforeKnowledge<?>> clazz;
	
	public <T extends BeforeKnowledge<?>> AbstractNothingBeforeStartClosureRule(String description, Class<T> clazz)
	{
		super(description);
		this.clazz = clazz;
	}

	@Override
	public <T extends Node> ListKnowledge<T> calculateClosure(ListKnowledge<T> term)
	{
		if (this.clazz.isInstance(term))
		{
			BeforeKnowledge<T> beforeKnowledge = (BeforeKnowledge<T>) term;
			if (beforeKnowledge.getAnchor() instanceof StartElement<?>)
			{
				return new ConflictKnowledgeImpl<T>(new RuleKnowledgeSourceImpl<T>(this, Collections.singleton(term)));
			}
		}
		return null;
	}
}
