package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source;

import java.util.Collection;
import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ClosureRule;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.RuleKnowledgeSource;

public class RuleKnowledgeSourceImpl<T extends Node> extends KnowledgeSourceImpl<T> implements RuleKnowledgeSource<T>
{
	private ClosureRule rule;
	private Collection<ListKnowledge<T>> knowledge;
	
	public RuleKnowledgeSourceImpl(ClosureRule rule, Collection<ListKnowledge<T>> knowledge)
	{
		super();
		this.rule = rule;
		this.knowledge = Collections.unmodifiableCollection(knowledge);
	}

	public ClosureRule getRule()
	{
		return this.rule;
	}
	
	public Collection<ListKnowledge<T>> getKnowledge()
	{
		return this.knowledge;
	}
}
