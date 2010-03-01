package edu.jhu.cs.bsj.compiler.impl.ast;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

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
	private Logger LOGGER = Logger.getLogger(this.getClass());

	/** A registry mapping node information objects to weak references of themselves. */
	private Map<NodeInfo, WeakReference<NodeInfo>> infoMap;
	/** The current permission policy manager for nodes. If this manager is null, any mutation is permitted. */
	private PermissionPolicyManager permissionPolicyManager;

	/**
	 * Creates a new node manager.
	 */
	public BsjNodeManager()
	{
		this.infoMap = new WeakHashMap<NodeInfo, WeakReference<NodeInfo>>();
		this.permissionPolicyManager = null;
	}

	/**
	 * Ensures that an entry exists in the node info map for the specified node.
	 */
	protected NodeInfo ensureEntry(Node node)
	{
		WeakReference<NodeInfo> reference = this.infoMap.get(new NodeInfo(node));
		NodeInfo ret = (reference == null ? null : reference.get());
		if (ret == null)
		{
			ret = new NodeInfo(node);
			this.infoMap.put(ret, new WeakReference<NodeInfo>(ret));
		}
		return ret;
	}

	/**
	 * Determines the parent of the specified node.
	 * 
	 * @param child The child whose parent is desired.
	 * @return The parent of that node or <code>null</code> if no such parent exists.
	 */
	public Node getParent(Node child)
	{
		return ensureEntry(child).getParent();
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
		ensureEntry(child).setParent(parent);
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
		ensureEntry(child).setParent(null);
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

	/**
	 * A class representing the extra information retained about nodes.  In order to make this object get garbage
	 * collected appropriately, it retains a reference to its own key and is only weakly reachable from this object.
	 */
	private static class NodeInfo
	{
		/** The node about which this information is relevant. */
		private Node node;
		/** The parent of the represented node. */
		private Node parent;
		
		public NodeInfo(Node node)
		{
			super();
			this.node = node;
		}
		
		public Node getNode()
		{
			return node;
		}
		public Node getParent()
		{
			return parent;
		}
		public void setParent(Node parent)
		{
			this.parent = parent;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = (int) (prime * result + ((node == null) ? 0 : node.getUid()));
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			NodeInfo other = (NodeInfo) obj;
			if (node == null)
			{
				if (other.node != null)
					return false;
			} else if (node.getUid() != other.node.getUid())
				return false;
			return true;
		}
		
		
	}

}
