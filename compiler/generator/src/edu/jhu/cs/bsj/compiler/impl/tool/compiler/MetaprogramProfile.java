package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

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
	/** The context to use when executing the metaprogram. */
	private Context<T> context;

	// TODO: dependency analysis metadata?
	public MetaprogramProfile(BsjMetaprogram<T> metaprogram, Context<T> context)
	{
		super();
		this.metaprogram = metaprogram;
		this.context = context;
	}

	public BsjMetaprogram<T> getMetaprogram()
	{
		return metaprogram;
	}

	public Context<T> getContext()
	{
		return context;
	}

}
