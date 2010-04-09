package edu.jhu.cs.bsj.compiler.impl.tool.serializer;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * This mechanism maps positions in a serialized source file to the AST nodes which were serialized to generate the
 * text at those positions.
 * @author Zachary Palmer
 */
public interface SerializedNodeMap
{
	/**
	 * Determines which node is responsible for the specified line and column number.
	 * @param line The line number.
	 * @param column The column number.
	 * @return The node whichc is responsible for that position or <code>null</code> if no such node exists.
	 */
	public Node get(int line, int column);
}
