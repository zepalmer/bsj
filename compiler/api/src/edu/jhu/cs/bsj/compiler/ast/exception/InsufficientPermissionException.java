package edu.jhu.cs.bsj.compiler.ast.exception;

import edu.jhu.cs.bsj.compiler.ast.NodePermission;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Indicates that a metaprogram attempted to access a node in a fashion which is not permitted.
 * @author Zachary Palmer
 */
public class InsufficientPermissionException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	/** The node in question. */
	private Node node;
	/** The permission required to access the node in the requested fashion. */
	private NodePermission requiredPermission;
	/** The permission that the metaprogram actually had to the node. */
	private NodePermission availablePermission;
	
	public InsufficientPermissionException(Node node, NodePermission requiredPermission, NodePermission availablePermission)
	{
		super();
		init(node, requiredPermission, availablePermission);
	}

	public InsufficientPermissionException(String message, NodePermission requiredPermission, Node node, NodePermission availablePermission)
	{
		super(message);
		init(node, requiredPermission, availablePermission);
	}

	public InsufficientPermissionException(Throwable cause, NodePermission requiredPermission, Node node, NodePermission availablePermission)
	{
		super(cause);
		init(node, requiredPermission, availablePermission);
	}

	public InsufficientPermissionException(String message, Throwable cause, NodePermission requiredPermission, Node node, NodePermission availablePermission)
	{
		super(message, cause);
		init(node, requiredPermission, availablePermission);
	}

	private void init(Node node, NodePermission requiredPermission, NodePermission availablePermission)
	{
		this.node = node;
		this.requiredPermission = requiredPermission;
		this.availablePermission = availablePermission;
	}
	
	public Node getNode()
	{
		return this.node;
	}

	public NodePermission getRequiredPermission()
	{
		return requiredPermission;
	}

	public NodePermission getAvailablePermission()
	{
		return availablePermission;
	}
}
