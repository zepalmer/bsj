package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import java.util.concurrent.atomic.AtomicInteger;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

/**
 * This class acts as a base class for generated BSJ metaprograms.
 * @author Zachary Palmer
 * @param <T> The type of anchor node associated with this metaprogram.
 */
public abstract class AbstractMetaprogram<T extends MetaprogramAnchorNode<U>, U extends Node> implements Metaprogram<T,U>
{
	/** The next UID to be assigned to a metaprogram. */
	private static final AtomicInteger NEXT_ID = new AtomicInteger(0);
	
	/** The ID number of this metaprogram. */
	private int id = NEXT_ID.getAndIncrement();
	
	/**
	 * Instantiates this metaprogram.
	 * @param context The context this metaprogram will use.
	 */
	public AbstractMetaprogram()
	{
		super();
	}

	/**
	 * Executes this metaprogram.  This method should be overridden with an implementation that contains the
	 * metaprogrammer's code.
	 * @param context The context in which to execute the metaprogram.
	 */
	public abstract void execute(Context<T,U> context);
	
	/**
	 * Retrieves the ID number for this metaprogram.
	 * @return This metaprogram's unique ID.
	 */
	public int getID()
	{
		return this.id;
	}
}
