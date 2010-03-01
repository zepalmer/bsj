package edu.jhu.cs.bsj.compiler.impl.ast;

import java.util.HashMap;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * The node manager is used to provide a common, central interface for all nodes created by a given factory. Nodes call
 * against the manager to discover information such as the current modification policy or to report information such as
 * the modification of properties.
 * 
 * @author Zachary Palmer
 */
public class BsjNodeManager
{
	/** A registry mapping nodes to their parents. */
	private Map<Node, Node> parentMap;

	/**
	 * Creates a new node manager.
	 */
	public BsjNodeManager()
	{
		this.parentMap = new HashMap<Node, Node>();
	}
	
	/**
	 * Determines the parent of the specified node.
	 * @param child The child whose parent is desired.
	 * @return The parent of that node or <code>null</code> if no such parent exists.
	 */
	public Node getParent(Node child)
	{
		return this.parentMap.get(child);
	}

	/**
	 * Called by a node to indicate that the specified node is now its child.
	 * 
	 * @param parent The calling node.
	 * @param child The child node which is being added.
	 */
	public void addParent(Node parent, Node child)
	{
		// TODO: exception if the specified child already has a parent
		this.parentMap.put(child, parent);
	}

	/**
	 * Called by a node to indicate that the specified node is no longer its child.
	 * 
	 * @param parent The calling node.
	 * @param child The child node which is being dropped.
	 */
	public void removeParent(Node parent, Node child)
	{
		// TODO: exception if the specified parent is not the parent of this child
		this.parentMap.remove(child);
	}
}
