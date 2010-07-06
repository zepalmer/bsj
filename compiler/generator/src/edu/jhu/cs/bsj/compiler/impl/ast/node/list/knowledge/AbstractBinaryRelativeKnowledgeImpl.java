package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.BinaryRelativeKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.SymbolicElement;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.KnowledgeSource;

public abstract class AbstractBinaryRelativeKnowledgeImpl<T extends Node> extends AbstractBinaryKnowledgeImpl<T> implements
		BinaryRelativeKnowledge<T>
{
	public AbstractBinaryRelativeKnowledgeImpl(int metaprogramId, BsjSourceLocation metaprogramSourceLocation,
			KnowledgeSource<T> knowledgeSource, SymbolicElement<T> first, SymbolicElement<T> second)
	{
		super(metaprogramId, metaprogramSourceLocation, knowledgeSource, first, second);
	}

	@Override
	public SymbolicElement<T> getAnchor()
	{
		return getFirst();
	}

	@Override
	public SymbolicElement<T> getRelative()
	{
		return getSecond();
	}
}
