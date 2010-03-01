package edu.jhu.cs.bsj.compiler.impl.ast;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.NodePermission;
import edu.jhu.cs.bsj.compiler.ast.exception.InsufficientPermissionException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.PermissionPolicyManager;

/**
 * The node manager is used to provide a common, central interface for all nodes created by a given factory. Nodes call
 * against the manager to discover information such as the current modification policy or to report information such as
 * the modification of properties.
 * 
 * @author Zachary Palmer
 */
public class BsjNodeManager
{
	/** A logger for this object. */
	@SuppressWarnings("unused")
	private Logger LOGGER = Logger.getLogger(this.getClass());

	/** The current permission policy manager for nodes. If this manager is null, any mutation is permitted. */
	private PermissionPolicyManager permissionPolicyManager;

	/**
	 * Creates a new node manager.
	 */
	public BsjNodeManager()
	{
		this.permissionPolicyManager = null;
	}

	public PermissionPolicyManager getPermissionPolicyManager()
	{
		return permissionPolicyManager;
	}

	public void setPermissionPolicyManager(PermissionPolicyManager permissionPolicyManager)
	{
		this.permissionPolicyManager = permissionPolicyManager;
	}
	
	/**
	 * Determines the currently available permission to the specified node.
	 * @param node The node in question.
	 * @return The current permission to that node.
	 */
	public NodePermission getPermission(Node node)
	{
		if (this.permissionPolicyManager == null)
		{
			return NodePermission.MUTATE;
		} else
		{
			return this.permissionPolicyManager.getPermission(node);
		}
	}
	
	/**
	 * Asserts that permission to the specified node includes the ability to read.
	 * @param node The node in question.
	 * @throws InsufficientPermissionException If the node is not readable.
	 */
	public void assertReadable(Node node) throws InsufficientPermissionException
	{
		NodePermission permission = getPermission(node);
		if (!permission.isReadable())
		{
			throw new InsufficientPermissionException(node, NodePermission.READ, permission);
		}
	}
	
	/**
	 * Asserts that permission to the specified node includes the ability to insert.
	 * @param node The node in question.
	 * @throws InsufficientPermissionException If the node is not insertable.
	 */
	public void assertInsertable(Node node) throws InsufficientPermissionException
	{
		NodePermission permission = getPermission(node);
		if (!permission.isInsertable())
		{
			throw new InsufficientPermissionException(node, NodePermission.INSERT, permission);
		}
	}
	
	/**
	 * Asserts that permission to the specified node includes the ability to mutate.
	 * @param node The node in question.
	 * @throws InsufficientPermissionException If the node is not mutatable.
	 */
	public void assertMutatable(Node node) throws InsufficientPermissionException
	{
		NodePermission permission = getPermission(node);
		if (!permission.isMutatable())
		{
			throw new InsufficientPermissionException(node, NodePermission.MUTATE, permission);
		}
	}

}
