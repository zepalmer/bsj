package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

/**
 * This class acts as a base class for generated BSJ metaprograms.
 * @author Zachary Palmer
 * @param <T> The type of anchor node associated with this metaprogram.
 */
public abstract class AbstractBsjMetaprogram<T extends MetaprogramAnchorNode<?>> implements BsjMetaprogram<T>
{
	/** The context for this metaprogram. */
	private Context<T> context;
	
	// TODO: do we want to move the context to a field on execute()?
	// this would decrease the amount of control we have over the field (user could write to it)... but do we care?
	// it's their own fault if they foul up their context field
	/**
	 * Instantiates this metaprogram.
	 * @param context The context this metaprogram will use.
	 */
	public AbstractBsjMetaprogram(Context<T> context)
	{
		super();
		this.context = context;
	}

	/**
	 * Retrieves the context for this metaprogram.
	 * @return The metaprogram context.
	 */
	public Context<T> getContext()
	{
		return context;
	}
	
	/**
	 * Executes this metaprogram.  This method should be overridden with an implementation that contains the
	 * metaprogrammer's code.
	 */
	public abstract void execute();
}
