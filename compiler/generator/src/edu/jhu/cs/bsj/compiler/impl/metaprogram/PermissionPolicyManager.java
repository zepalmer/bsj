package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import java.util.HashMap;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.NodePermission;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * This class is used to determine the permissions that a metaprogram has when accessing a node.
 * 
 * @author Zachary Palmer
 */
public class PermissionPolicyManager
{
	/**
	 * The permission thresholds which have been recorded. Each of these mappings indicate the permissions which should
	 * be applied to the key node and its descendents except for those descendents with a nearer ancestor also in this
	 * map.
	 */
	private Map<Node, NodePermission> thresholdMap;
	
	/**
	 * Creates a new permission policy manager with read-only permission to all nodes.
	 * @param rootPackage The node for the root package.
	 */
	public PermissionPolicyManager(Node rootPackage)
	{
		this.thresholdMap = new HashMap<Node, NodePermission>();
		this.thresholdMap.put(rootPackage, NodePermission.READ);
	}
	
	/**
	 * Adds a threshold to this policy manager.
	 * @param node The node in question.
	 * @param permission The permission to apply to that node and all of its descendents.
	 */
	public void addThreshold(Node node, NodePermission permission)
	{
		this.thresholdMap.put(node, permission);
	}

	/**
	 * Determines the level of permission that a metaprogram has to the specified node.
	 * 
	 * @param node The node in question.
	 * @return The permission available to the caller.
	 */
	public NodePermission getPermission(Node node)
	{
		while (node != null)
		{
			NodePermission permission = this.thresholdMap.get(node);
			if (permission != null)
			{
				return permission;
			}
			node = node.getParent();
		}
		// Allow any operations on a node not connected to the root package.
		return NodePermission.MUTATE;
	}
}
