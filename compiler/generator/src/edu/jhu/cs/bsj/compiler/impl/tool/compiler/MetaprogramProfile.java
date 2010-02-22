package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.util.Collection;

import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.BsjMetaprogram;

/**
 * Represents a metaprogram which has been extracted and is prepared to execute.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of the metaprogram's anchor node.
 */
public class MetaprogramProfile
{
	/** The metaprogram object which will be executed. */
	private BsjMetaprogram<?> metaprogram;
	/** The anchor for this metaprogram. */
	private MetaprogramAnchorNode<?> anchor;
	
	/** The fully-qualified names of the targets on which the metaprogram in this profile depends. */
	private Collection<String> dependencyNames;
	/** The fully-qualified names of the targets in which the metaprogram in this profile participates. */
	private Collection<String> targetNames;
	
	// TODO: dependency analysis metadata?
	public MetaprogramProfile(BsjMetaprogram<?> metaprogram, MetaprogramAnchorNode<?> anchor,
			Collection<String> dependencyNames, Collection<String> targetNames)
	{
		super();
		this.metaprogram = metaprogram;
		this.anchor = anchor;
		this.dependencyNames = dependencyNames;
		this.targetNames = targetNames;
	}

	public BsjMetaprogram<?> getMetaprogram()
	{
		return metaprogram;
	}
	
	public MetaprogramAnchorNode<?> getAnchor()
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
}
