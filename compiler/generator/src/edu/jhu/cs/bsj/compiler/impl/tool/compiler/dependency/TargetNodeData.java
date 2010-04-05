package edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency;

/**
 * Represents the data contained in a target node.
 * @author Zachary Palmer
 */
public class TargetNodeData
{
	/** The fully-qualified name of the target. */
	private String target;

	public TargetNodeData(String target)
	{
		super();
		this.target = target;
	}

	public String getTarget()
	{
		return target;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((target == null) ? 0 : target.hashCode());
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
		TargetNodeData other = (TargetNodeData) obj;
		if (target == null)
		{
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "TargetNodeData [target=" + target + "]";
	}
}
