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
	 * Executes this metaprogram.  This method should be overridden with an implementation that contains the
	 * metaprogrammer's code.
	 * @param context The context in which to execute.
	 */
	public void execute(Context<T> context);

	/**
	 * Retrieves the ID number of this metaprogram.  Metaprogram IDs must be unique for any given compilation pass.
	 * @return The metaprogram ID.
	 */
	public int getID();
}