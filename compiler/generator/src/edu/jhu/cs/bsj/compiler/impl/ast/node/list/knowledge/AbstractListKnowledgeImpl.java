package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.KnowledgeSource;

public abstract class AbstractListKnowledgeImpl<T extends Node> implements ListKnowledge<T>
{
	private KnowledgeSource<T> knowledgeSource;

	public AbstractListKnowledgeImpl(KnowledgeSource<T> knowledgeSource)
	{
		super();
		this.knowledgeSource = knowledgeSource;
	}

	@Override
	public KnowledgeSource<T> getKnowledgeSource()
	{
		return this.knowledgeSource;
	}
}