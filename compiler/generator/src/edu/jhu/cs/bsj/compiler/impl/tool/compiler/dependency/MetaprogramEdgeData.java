package edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency;

/**
 * This is the type of edge data for an edge leaving a metaprogram node.
 * @author Zachary Palmer
 */
public class MetaprogramEdgeData extends EdgeData
{
	/** Indicates whether or not this dependency is weak. */
	private boolean weak;

	public MetaprogramEdgeData(boolean inferred, boolean weak)
	{
		super(inferred);
		this.weak = weak;
	}

	public boolean isWeak()
	{
		return weak;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (weak ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetaprogramEdgeData other = (MetaprogramEdgeData) obj;
		if (weak != other.weak)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "MetaprogramEdgeData [weak=" + weak + ", inferred=" + isInferred() + "]";
	}
}
