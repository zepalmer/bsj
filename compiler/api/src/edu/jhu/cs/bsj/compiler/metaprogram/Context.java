package edu.jhu.cs.bsj.compiler.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;

/**
 * Represents the execution context for a metaprogram.  Instances of this interface are provided to metaprograms to
 * allow them access to their environments, allowing modification of AST nodes in their own compilation unit and other
 * relevant facilities.
 * 
 * @author Zachary Palmer
 * @param <T> The type of metaprogram anchor node held by this context.
 */
public interface Context<T extends MetaprogramAnchorNode<?>>
{
	/**
	 * Retrieves the anchor node for this metaprogram context.  In a BSJ AST, all metaprograms exist within an anchor
	 * node (or have no parent).  This method allows the metaprogram which received this context to find its own anchor,
	 * allowing it to use its location within the AST for semantic meaning.
	 * @return The anchor node for this metaprogram context.
	 */
	public T getAnchor();
}
