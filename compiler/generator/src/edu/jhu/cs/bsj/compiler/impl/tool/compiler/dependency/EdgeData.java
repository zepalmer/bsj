package edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency;

/**
 * Represents the data associated with an edge on the dependency graph.
 * 
 * @author Zachary Palmer
 */
public class EdgeData
{
	/** Whether or not this edge was inferred from a metaprogram injection. */
	private boolean inferred;

	public EdgeData(boolean inferred)
	{
		super();
		this.inferred = inferred;
	}

	public boolean isInferred()
	{
		return inferred;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (inferred ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EdgeData other = (EdgeData) obj;
		if (inferred != other.inferred)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "EdgeData [inferred=" + inferred + "]";
	}
}
