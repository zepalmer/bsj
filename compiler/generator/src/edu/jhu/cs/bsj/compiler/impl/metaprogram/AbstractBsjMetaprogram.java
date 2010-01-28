package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;

/**
 * This class acts as a base class for generated BSJ metaprograms.
 * @author Zachary Palmer
 * @param <T> The type of anchor node associated with this metaprogram.
 */
public abstract class AbstractBsjMetaprogram<T extends MetaprogramAnchorNode<?>>
{
	/** The context for this metaprogram. */
	private T context;
	
	/**
	 * Instantiates this metaprogram.
	 * @param context The context this metaprogram will use.
	 */
	public AbstractBsjMetaprogram(T context)
	{
		super();
		this.context = context;
	}

	/**
	 * Retrieves the context for this metaprogram.
	 * @return The metaprogram context.
	 */
	public T getContext()
	{
		return context;
	}
	
	/**
	 * Executes this metaprogram.  This method should be overridden with an implementation that contains the
	 * metaprogrammer's code.
	 */
	public abstract void execute();
}
