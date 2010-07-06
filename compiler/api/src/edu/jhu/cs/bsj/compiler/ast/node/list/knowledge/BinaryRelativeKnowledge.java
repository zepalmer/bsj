package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents a binary knowledge unit which has to do with the relative position of one of the element arguments with
 * respect to the other.  The <code>first</code> property of the binary knowledge is always used as the anchor; the
 * <code>second</code> property is always used as the relative element.
 * @author Zachary Palmer
 * @param <T> The type of data stored in the list to which this knowledge pertains.
 */
public interface BinaryRelativeKnowledge<T extends Node> extends BinaryKnowledge<T>
{
	/**
	 * Retrieves the anchor element for this knowledge.
	 * @return The anchor element for this knowledge.
	 */
	public SymbolicElement<T> getAnchor();
	
	/**
	 * Retrieves the relative element for this knowledge.
	 * @return The relative element for this knowledge.
	 */
	public SymbolicElement<T> getRelative();
}
