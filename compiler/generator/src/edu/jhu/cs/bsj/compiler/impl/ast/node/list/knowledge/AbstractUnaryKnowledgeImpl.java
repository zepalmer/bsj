package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.SymbolicElement;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.UnaryKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.KnowledgeSource;

public abstract class AbstractUnaryKnowledgeImpl<T extends Node> extends AbstractSingleMetaprogramListKnowledgeImpl<T> implements UnaryKnowledge<T>
{
	/** The list element for this knowledge. */
	private SymbolicElement<T> element;

	public AbstractUnaryKnowledgeImpl(int metaprogramId, BsjSourceLocation metaprogramSourceLocation,
			KnowledgeSource<T> knowledgeSource, SymbolicElement<T> element)
	{
		super(metaprogramId, metaprogramSourceLocation, knowledgeSource);
		this.element = element;
	}

	@Override
	public SymbolicElement<T> getElement()
	{
		return this.element;
	}

	@Override
	public boolean equals(Object o)
	{
		if (o instanceof AbstractUnaryKnowledgeImpl<?>)
		{
			AbstractUnaryKnowledgeImpl<?> other = (AbstractUnaryKnowledgeImpl<?>) o;

			if (!equalsPartial(other))
				return false;

			if (!this.getElement().equals(other.getElement()))
				return false;

			return true;
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return (hashCodePartial() * 7) + getElement().hashCode();
	}
}
