package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.BinaryKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.SymbolicElement;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.KnowledgeSource;

public abstract class AbstractBinaryKnowledgeImpl<T extends Node> extends AbstractSingleMetaprogramListKnowledgeImpl<T> implements
		BinaryKnowledge<T>
{
	/** The first element for this knowledge. */
	private SymbolicElement<T> first;
	/** The second element for this knowledge. */
	private SymbolicElement<T> second;
	
	public AbstractBinaryKnowledgeImpl(int metaprogramId, BsjSourceLocation metaprogramSourceLocation,
			KnowledgeSource<T> knowledgeSource, SymbolicElement<T> first, SymbolicElement<T> second)
	{
		super(metaprogramId, metaprogramSourceLocation, knowledgeSource);
		this.first = first;
		this.second = second;
	}

	@Override
	public SymbolicElement<T> getFirst()
	{
		return this.first;
	}

	@Override
	public SymbolicElement<T> getSecond()
	{
		return this.second;
	}


	@Override
	public boolean equals(Object o)
	{
		if (o instanceof AbstractBinaryKnowledgeImpl<?>)
		{
			AbstractBinaryKnowledgeImpl<?> other = (AbstractBinaryKnowledgeImpl<?>) o;

			if (!equalsPartial(other))
				return false;

			if (!this.getFirst().equals(other.getFirst()))
				return false;

			if (!this.getSecond().equals(other.getSecond()))
				return false;

			return true;
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return ((hashCodePartial() * 7) + getFirst().hashCode() * 7) + getSecond().hashCode();
	}
}
