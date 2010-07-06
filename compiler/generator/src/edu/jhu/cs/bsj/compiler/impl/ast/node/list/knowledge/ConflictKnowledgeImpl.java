package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ConflictKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.RuleKnowledgeSource;

public class ConflictKnowledgeImpl<T extends Node> extends AbstractListKnowledgeImpl<T> implements ConflictKnowledge<T>
{
	public ConflictKnowledgeImpl(RuleKnowledgeSource<T> knowledgeSource)
	{
		super(knowledgeSource);
	}

	@Override
	public String toString()
	{
		return KnowledgeUtilities.CONTRADICTION;
	}

	@Override
	public RuleKnowledgeSource<T> getKnowledgeSource()
	{
		return (RuleKnowledgeSource<T>)super.getKnowledgeSource();
	}
}
