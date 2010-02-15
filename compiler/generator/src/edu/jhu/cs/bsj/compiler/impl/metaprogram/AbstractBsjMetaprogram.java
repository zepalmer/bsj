package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import java.util.concurrent.atomic.AtomicInteger;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

/**
 * This class acts as a base class for generated BSJ metaprograms.
 * @author Zachary Palmer
 * @param <T> The type of anchor node associated with this metaprogram.
 */
public abstract class AbstractBsjMetaprogram<T extends MetaprogramAnchorNode<?>> implements BsjMetaprogram<T>
{
	/** The next UID to be assigned to a metaprogram. */
	private static final AtomicInteger NEXT_ID = new AtomicInteger(0);
	
	/** The context for this metaprogram. */
	private Context<T> context;
	/** The node factory for this metaprogram. */
	private BsjNodeFactory factory;
	/** The ID number of this metaprogram. */
	private int id = NEXT_ID.getAndIncrement();
	
	// TODO: do we want to move the context to a field on execute()?
	// this would decrease the amount of control we have over the field (user could write to it)... but do we care?
	// it's their own fault if they foul up their context field
	/**
	 * Instantiates this metaprogram.
	 * @param context The context this metaprogram will use.
	 */
	public AbstractBsjMetaprogram(Context<T> context, BsjNodeFactory factory)
	{
		super();
		this.context = context;
		this.factory = factory;
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
	 * Retrieves the node factory that this metaprogram is expected to use to create new nodes.
	 * @return The node factory to use.
	 */
	public BsjNodeFactory getFactory()
	{
		return factory;
	}

	/**
	 * Executes this metaprogram.  This method should be overridden with an implementation that contains the
	 * metaprogrammer's code.
	 */
	public abstract void execute();
	
	/**
	 * Retrieves the ID number for this metaprogram.
	 * @return This metaprogram's unique ID.
	 */
	public int getID()
	{
		return this.id;
	}
}
