package edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency;

import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;

/**
 * Represents the data contained in a metaprogram node.
 * @author Zachary Palmer
 */
public class MetaprogramNodeData
{
	/** The profile for this metaprogram. */
	private MetaprogramProfile<?> profile;

	public MetaprogramNodeData(MetaprogramProfile<?> profile)
	{
		super();
		this.profile = profile;
	}

	public MetaprogramProfile<?> getProfile()
	{
		return profile;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
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
		MetaprogramNodeData other = (MetaprogramNodeData) obj;
		if (profile == null)
		{
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		return true;
	}
}
