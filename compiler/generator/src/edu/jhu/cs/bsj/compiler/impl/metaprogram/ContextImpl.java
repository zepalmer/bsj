package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

/**
 * Represents a standard context implementation.
 * @author Zachary Palmer
 *
 * @param <T> The type of anchor node held by this context.
 */
public class ContextImpl<T extends MetaprogramAnchorNode<?>> implements Context<T>
{
	/** The anchor for this context. */
	private T anchor;
	
	/**
	 * Creates a standard context implementation.
	 * @param anchor The anchor to use.
	 */
	public ContextImpl(T anchor)
	{
		super();
		this.anchor = anchor;
	}

	@Override
	public T getAnchor()
	{
		return this.anchor;
	}
}
