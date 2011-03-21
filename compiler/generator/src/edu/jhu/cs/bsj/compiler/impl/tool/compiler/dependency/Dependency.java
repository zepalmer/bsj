package edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency;

/**
 * A data structure representing a dependency in a metaprogram's profile.
 * 
 * @author Zachary Palmer
 */
public class Dependency
{
    // TODO: metaprogram targets should be more than just a string to prevent confusion between packages and classes
    // or just use $ as a type separator
    
	/** The name of the metaprogram target on which to depend. */
	private String name;
	/** <code>true</code> if this dependency is weak; <code>false</code> otherwise. */
	private boolean weak;

	public Dependency(String name, boolean weak)
	{
		super();
		this.name = name;
		this.weak = weak;
	}

	public String getName()
	{
		return name;
	}

	public boolean isWeak()
	{
		return weak;
	}

	@Override
	public String toString()
	{
		return "[name=" + name + ", weak=" + weak + "]";
	}

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (weak ? 1231 : 1237);
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
        Dependency other = (Dependency) obj;
        if (name == null)
        {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (weak != other.weak)
            return false;
        return true;
    }
}
