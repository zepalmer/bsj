package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

/**
 * The interface for BSJ metaprograms.
 * @author Zachary Palmer
 *
 * @param <T> The type of anchor for this metaprogram.
 */
public interface BsjMetaprogram<T extends MetaprogramAnchorNode<?>>
{
	/**
	 * Retrieves the context for this metaprogram.
	 * @return The metaprogram context.
	 */
	public Context<T> getContext();

	/**
	 * Executes this metaprogram.  This method should be overridden with an implementation that contains the
	 * metaprogrammer's code.
	 */
	public void execute();

}