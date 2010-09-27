package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.util.Collection;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
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
 * @param <U> The type of replacement the anchor uses.
 */
public class MetaprogramProfile<T extends MetaprogramAnchorNode<U>, U extends Node>
{
	/** The metaprogram object which will be executed. */
	private Metaprogram<T,U> metaprogram;
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
	private Context<T,U> context;
	/**
	 * Controls whether or not this metaprogram was purely injected. This is <code>true</code> if it was injected by
	 * another metaprogram directly and <code>false</code> if it was loaded directly by the meta-compiler or by an
	 * invocation of {@link PackageNode#load}.
	 */
	private boolean purelyInjected;

	public MetaprogramProfile(Metaprogram<T,U> metaprogram, T anchor, Collection<Dependency> dependencies,
			Collection<String> targetNames, MetaprogramLocalMode localMode, MetaprogramPackageMode packageMode,
			Context<T,U> context, boolean purelyInjected)
	{
		super();
		this.metaprogram = metaprogram;
		this.anchor = anchor;
		this.dependencies = dependencies;
		this.targetNames = targetNames;
		this.localMode = localMode;
		this.packageMode = packageMode;
		this.context = context;
		this.purelyInjected = purelyInjected;
	}

	public Metaprogram<T,U> getMetaprogram()
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

	public Context<T,U> getContext()
	{
		return context;
	}

	public boolean isPurelyInjected()
	{
		return purelyInjected;
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
		if (obj instanceof MetaprogramProfile<?,?>)
		{
			return getMetaprogram().getID() == ((MetaprogramProfile<?,?>) obj).getMetaprogram().getID();
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
