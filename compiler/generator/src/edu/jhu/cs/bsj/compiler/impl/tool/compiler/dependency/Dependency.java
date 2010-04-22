package edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency;

/**
 * A data structure representing a dependency in a metaprogram's profile.
 * 
 * @author Zachary Palmer
 */
public class Dependency
{
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

}
