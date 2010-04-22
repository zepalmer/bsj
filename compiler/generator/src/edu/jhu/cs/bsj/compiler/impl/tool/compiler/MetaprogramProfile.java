package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.util.Collection;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.Metaprogram;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.Dependency;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

/**
 * Represents a metaprogram which has been extracted and is prepared to execute.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of the metaprogram's anchor node.
 */
public class MetaprogramProfile<T extends MetaprogramAnchorNode<?>>
{
	/** The metaprogram object which will be executed. */
	private Metaprogram<T> metaprogram;
	/** The anchor for this metaprogram. */
	private T anchor;
	
	/** The fully-qualified names of the targets on which the metaprogram in this profile depends. */
	private Collection<Dependency> dependencies;
	/** The fully-qualified names of the targets in which the metaprogram in this profile participates. */
	private Collection<String> targetNames;
	/** The local mode of this metaprogram. */
	private MetaprogramLocalMode localMode;
	/** The package mode of this metaprogram. */
	private MetaprogramPackageMode packageMode;
	/** The context in which to execute the metaprogram. */
	private Context<T> context;
	
	public MetaprogramProfile(Metaprogram<T> metaprogram, T anchor, Collection<Dependency> dependencies,
			Collection<String> targetNames, MetaprogramLocalMode localMode, MetaprogramPackageMode packageMode,
			Context<T> context)
	{
		super();
		this.metaprogram = metaprogram;
		this.anchor = anchor;
		this.dependencies = dependencies;
		this.targetNames = targetNames;
		this.localMode = localMode;
		this.packageMode = packageMode;
		this.context = context;
	}

	public Metaprogram<T> getMetaprogram()
	{
		return metaprogram;
	}

	public T getAnchor()
	{
		return anchor;
	}

	public Collection<Dependency> getDependencies()
	{
		return dependencies;
	}

	public Collection<String> getTargetNames()
	{
		return targetNames;
	}

	public MetaprogramLocalMode getLocalMode()
	{
		return localMode;
	}

	public MetaprogramPackageMode getPackageMode()
	{
		return packageMode;
	}

	public Context<T> getContext()
	{
		return context;
	}
	
	/**
	 * Retrieves the location in source code where the metaprogram indicated by this profile was declared.
	 */
	public BsjSourceLocation getLocation()
	{
		return this.context.getAnchor().getStartLocation();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof MetaprogramProfile<?>)
		{
			return getMetaprogram().getID() == ((MetaprogramProfile<?>)obj).getMetaprogram().getID();
		} else
		{
			return false;
		}
	}

	@Override
	public int hashCode()
	{
		return getMetaprogram().getID();
	}

	@Override
	public String toString()
	{
		return "MetaprogramProfile [location=" + getLocation() + ", id=" + getMetaprogram().getID() + "]";
	}
}
