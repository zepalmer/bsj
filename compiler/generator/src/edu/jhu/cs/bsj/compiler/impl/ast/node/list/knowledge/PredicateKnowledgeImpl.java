package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.INVARIANT_LEFT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.INVARIANT_RIGHT;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.PredicateKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.KnowledgeSource;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.METAPROG_PREFIX;

public class PredicateKnowledgeImpl<T extends Node> extends AbstractSingleMetaprogramListKnowledgeImpl<T> implements
		PredicateKnowledge<T>
{
	/** The predicate which was used. */
	private NodeFilter<? super T> filter;

	public PredicateKnowledgeImpl(int metaprogramId, BsjSourceLocation metaprogramSourceLocation,
			KnowledgeSource<T> knowledgeSource, NodeFilter<? super T> filter)
	{
		super(metaprogramId, metaprogramSourceLocation, knowledgeSource);
		this.filter = filter;
	}

	@Override
	public String toString()
	{
		return INVARIANT_LEFT + this.filter.toString() + INVARIANT_RIGHT + METAPROG_PREFIX + getMetaprogramId();
	}

	@Override
	public NodeFilter<? super T> getPredicate()
	{
		return this.filter;
	}

	@Override
	public boolean equals(Object o)
	{
		if (o instanceof PredicateKnowledgeImpl<?>)
		{
			PredicateKnowledgeImpl<?> other = (PredicateKnowledgeImpl<?>) o;
			
			if (!equalsPartial(other))
				return false;
			
			if (!this.filter.equals(other.getPredicate()))
				return false;

			return true;
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return hashCodePartial() + this.filter.hashCode();
	}
}
