package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.SingleMetaprogramListKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.KnowledgeSource;

/**
 * Represents an abstract base class for list knowledge units.
 * 
 * @author Zachary Palmer
 * @param <T> The type of element in the list to which this knowledge pertains.
 */
public abstract class AbstractSingleMetaprogramListKnowledgeImpl<T extends Node> extends AbstractListKnowledgeImpl<T>
		implements SingleMetaprogramListKnowledge<T>
{
	private int metaprogramId;
	private BsjSourceLocation metaprogramSourceLocation;

	public AbstractSingleMetaprogramListKnowledgeImpl(int metaprogramId, BsjSourceLocation metaprogramSourceLocation,
			KnowledgeSource<T> knowledgeSource)
	{
		super(knowledgeSource);
		this.metaprogramId = metaprogramId;
		this.metaprogramSourceLocation = metaprogramSourceLocation;
	}

	@Override
	public int getMetaprogramId()
	{
		return this.metaprogramId;
	}

	@Override
	public BsjSourceLocation getMetaprogramLocation()
	{
		return this.metaprogramSourceLocation;
	}

	/**
	 * Retrieves a string describing this knowledge object.
	 */
	public abstract String toString();

	/**
	 * Determines whether or not this {@link AbstractSingleMetaprogramListKnowledgeImpl} is equal to another. This is
	 * intended to be used for {@link Object#equals(Object)} implementations in subclasses.
	 * 
	 * @param other The other knowledge object.
	 */
	protected boolean equalsPartial(AbstractSingleMetaprogramListKnowledgeImpl<?> other)
	{
		if (other.getMetaprogramId() != this.metaprogramId)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Retrieves a partial hash code for this {@link AbstractSingleMetaprogramListKnowledgeImpl}.  This is intended to
	 * be used for {@link Object#hashCode()} implementations in subclasses.
	 * @return A hash code for this object.
	 */
	protected int hashCodePartial()
	{
		return this.metaprogramId;
	}

	public abstract boolean equals(Object o);

	public abstract int hashCode();
}
