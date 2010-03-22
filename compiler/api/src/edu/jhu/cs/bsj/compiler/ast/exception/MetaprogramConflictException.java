package edu.jhu.cs.bsj.compiler.ast.exception;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;

/**
 * Indicates that two metaprograms are in conflict because of the manner in which they accessed the same attribute of
 * a given node. 
 * @author Zachary Palmer
 */
public class MetaprogramConflictException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	/** The anchor for the first metaprogram that conflicted. */
	private MetaprogramAnchorNode<?> firstAnchor;
	/** The anchor for the second metaprogram that conflicted. */
	private MetaprogramAnchorNode<?> secondAnchor;
	/** The node over which the metaprograms conflicted. */
	private Node conflictNode;
	
	/**
	 * Creates a metaprogram conflict exception.
	 * @param firstAnchor The anchor of the first metaprogram in conflict.
	 * @param secondAnchor The anchor of the second metaprogram in conflict.
	 * @param conflictNode The node over which the two metaprograms conflicted.
	 */
	public MetaprogramConflictException(MetaprogramAnchorNode<?> firstAnchor, MetaprogramAnchorNode<?> secondAnchor,
			Node conflictNode)
	{
		super();
		this.firstAnchor = firstAnchor;
		this.secondAnchor = secondAnchor;
		this.conflictNode = conflictNode;
	}

	/**
	 * Retrieves the anchor of the first metaprogram that conflicted.
	 * @return The anchor of the first metaprogram that conflicted.
	 */
	public MetaprogramAnchorNode<?> getFirstAnchor()
	{
		return firstAnchor;
	}

	/**
	 * Retrieves the anchor of the second metaprogram that conflicted.
	 * @return The anchor of the second metaprogram that conflicted.
	 */
	public MetaprogramAnchorNode<?> getSecondAnchor()
	{
		return secondAnchor;
	}

	/**
	 * The node over which the two metaprograms are in conflict.
	 * @return The node in conflict.
	 */
	public Node getConflictNode()
	{
		return conflictNode;
	}
}
