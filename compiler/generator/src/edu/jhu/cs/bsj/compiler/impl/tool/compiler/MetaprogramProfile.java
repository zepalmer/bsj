package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.util.Collection;

import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.BsjMetaprogram;
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
	private BsjMetaprogram<T> metaprogram;
	/** The anchor for this metaprogram. */
	private T anchor;
	
	/** The fully-qualified names of the targets on which the metaprogram in this profile depends. */
	private Collection<String> dependencyNames;
	/** The fully-qualified names of the targets in which the metaprogram in this profile participates. */
	private Collection<String> targetNames;
	/** The local mode of this metaprogram. */
	private MetaprogramLocalMode localMode;
	/** The package mode of this metaprogram. */
	private MetaprogramPackageMode packageMode;
	/** The context in which to execute the metaprogram. */
	private Context<T> context;
	
	public MetaprogramProfile(BsjMetaprogram<T> metaprogram, T anchor, Collection<String> dependencyNames,
			Collection<String> targetNames, MetaprogramLocalMode localMode, MetaprogramPackageMode packageMode,
			Context<T> context)
	{
		super();
		this.metaprogram = metaprogram;
		this.anchor = anchor;
		this.dependencyNames = dependencyNames;
		this.targetNames = targetNames;
		this.localMode = localMode;
		this.packageMode = packageMode;
		this.context = context;
	}

	public BsjMetaprogram<T> getMetaprogram()
	{
		return metaprogram;
	}

	public T getAnchor()
	{
		return anchor;
	}

	public Collection<String> getDependencyNames()
	{
		return dependencyNames;
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
}
