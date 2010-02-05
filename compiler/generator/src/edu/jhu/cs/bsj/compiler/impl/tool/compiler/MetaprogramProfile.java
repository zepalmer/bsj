package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

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
	/** The tracker which is affected by this metaprogram. */
	private CompilationUnitTracker tracker;

	// TODO: dependency analysis metadata?
	public MetaprogramProfile(BsjMetaprogram<?> metaprogram, MetaprogramAnchorNode<?> anchor, CompilationUnitTracker tracker)
	{
		super();
		this.metaprogram = metaprogram;
		this.anchor = anchor;
		this.tracker = tracker;
	}

	public BsjMetaprogram<?> getMetaprogram()
	{
		return metaprogram;
	}
	
	public MetaprogramAnchorNode<?> getAnchor()
	{
		return anchor;
	}

	public CompilationUnitTracker getTracker()
	{
		return tracker;
	}
}
