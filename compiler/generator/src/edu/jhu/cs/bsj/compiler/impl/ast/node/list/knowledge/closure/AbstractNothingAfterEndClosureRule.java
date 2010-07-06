package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.AfterKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.EndElement;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.ConflictKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.RuleKnowledgeSourceImpl;

public class AbstractNothingAfterEndClosureRule extends AbstractUnaryKnowledgeClosureRule
{
	private Class<? extends AfterKnowledge<?>> clazz;
	
	public <T extends AfterKnowledge<?>> AbstractNothingAfterEndClosureRule(String description, Class<T> clazz)
	{
		super(description);
		this.clazz = clazz;
	}

	@Override
	public <T extends Node> ListKnowledge<T> calculateClosure(ListKnowledge<T> term)
	{
		if (this.clazz.isInstance(term))
		{
			AfterKnowledge<T> afterKnowledge = (AfterKnowledge<T>) term;
			if (afterKnowledge.getAnchor() instanceof EndElement<?>)
			{
				return new ConflictKnowledgeImpl<T>(new RuleKnowledgeSourceImpl<T>(this, Collections.singleton(term)));
			}
		}
		return null;
	}
}
