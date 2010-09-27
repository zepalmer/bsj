package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

/**
 * The interface for BSJ metaprograms.
 * @author Zachary Palmer
 *
 * @param <T> The type of anchor for this metaprogram.
 */
public interface Metaprogram<T extends MetaprogramAnchorNode<U>,U extends Node>
{
	/**
	 * Executes this metaprogram.  This method should be overridden with an implementation that contains the
	 * metaprogrammer's code.
	 * @param context The context in which to execute.
	 */
	public void execute(Context<T,U> context);

	/**
	 * Retrieves the ID number of this metaprogram.  Metaprogram IDs must be unique for any given compilation pass.
	 * @return The metaprogram ID.
	 */
	public int getID();
}