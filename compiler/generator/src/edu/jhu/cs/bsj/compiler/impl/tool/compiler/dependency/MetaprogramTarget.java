package edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency;

import java.util.Collection;
import java.util.HashSet;

import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;

/**
 * Represents a metaprogram target.
 * @author Zachary Palmer
 */
public class MetaprogramTarget
{
	/** The fully-qualified name of this target. */
	private String name;
	/** The nodes which are included in this target. */
	private Collection<MetaprogramProfile<?>> members;
	
	/**
	 * Creates a new metaprogram target.
	 * @param name The fully-qualified name of this target.
	 */
	public MetaprogramTarget(String name)
	{
		super();
		this.name = name;
		this.members = new HashSet<MetaprogramProfile<?>>();
	}

	/**
	 * The name of this target.
	 * @return the name of this target.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * The collection of members in this target.
	 * @return The members in this target.
	 */
	public Collection<MetaprogramProfile<?>> getMembers()
	{
		return members;
	}
}
