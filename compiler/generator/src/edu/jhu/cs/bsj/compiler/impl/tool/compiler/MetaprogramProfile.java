package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

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
	/** The tracker which is affected by this metaprogram. */
	private CompilationUnitTracker tracker;

	// TODO: dependency analysis metadata?
	public MetaprogramProfile(BsjMetaprogram<?> metaprogram, CompilationUnitTracker tracker)
	{
		super();
		this.metaprogram = metaprogram;
		this.tracker = tracker;
	}

	public BsjMetaprogram<?> getMetaprogram()
	{
		return metaprogram;
	}

	public CompilationUnitTracker getTracker()
	{
		return tracker;
	}
}
