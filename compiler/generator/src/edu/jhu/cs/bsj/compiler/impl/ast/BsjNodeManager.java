package edu.jhu.cs.bsj.compiler.impl.ast;

import java.util.Stack;

import javax.tools.DiagnosticListener;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodePermission;
import edu.jhu.cs.bsj.compiler.ast.exception.InsufficientPermissionException;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaAnnotationInstantiationFailureException;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.impl.ast.exception.InsufficientPermissionExceptionImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.exception.MetaprogramConflictExceptionImpl;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.PermissionPolicyManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.DependencyManager;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;

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

	/** The current permission policy manager for nodes. If this manager is null, any mutation is permitted. */
	private PermissionPolicyManager permissionPolicyManager;
	/**
	 * The current dependency manager for metaprogram dependency analysis. If null, all metaprograms are assumed to
	 * cooperate.
	 */
	private DependencyManager dependencyManager;
	/**
	 * The meta-annotation object instantiator used by this manager.
	 */
	private MetaAnnotationObjectInstantiator instantiator = new MetaAnnotationObjectInstantiator();

	/**
	 * The stack of running metaprogram IDs. This is specifically in place to permit code to temporarily suspend the
	 * running metaprograms (by pushing <code>null</code> onto the stack).
	 */
	private Stack<Integer> metaprogramIdStack;

	/**
	 * Creates a new node manager.
	 */
	public BsjNodeManager()
	{
		this.metaprogramIdStack = new Stack<Integer>();
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

	public DependencyManager getDependencyManager()
	{
		return dependencyManager;
	}

	public void setDependencyManager(DependencyManager dependencyManager)
	{
		this.dependencyManager = dependencyManager;
	}

	public Integer getCurrentMetaprogramId()
	{
		if (metaprogramIdStack.isEmpty())
		{
			return null;
		} else
		{
			return metaprogramIdStack.peek();
		}
	}
	
	public void pushCurrentMetaprogramId(Integer id)
	{
		this.metaprogramIdStack.push(id);
	}
	
	public void popCurrentMetaprogramId()
	{
		this.metaprogramIdStack.pop();
	}

	/**
	 * Determines the currently available permission to the specified node.
	 * 
	 * @param node The node in question.
	 * @return The current permission to that node.
	 */
	public NodePermission getPermission(Node node)
	{
		if (node.isBinary())
		{
			return NodePermission.READ;
		} else if (this.permissionPolicyManager == null)
		{
			return NodePermission.MUTATE;
		} else
		{
			return this.permissionPolicyManager.getPermission(node);
		}
	}

	/**
	 * Asserts that permission to the specified node includes the ability to read.
	 * 
	 * @param node The node in question.
	 * @throws InsufficientPermissionException If the node is not readable.
	 */
	public void assertReadable(Node node) throws InsufficientPermissionException
	{
		NodePermission permission = getPermission(node);
		if (!permission.isReadable())
		{
			throw new InsufficientPermissionExceptionImpl(node, NodePermission.READ, permission);
		}
	}

	/**
	 * Asserts that permission to the specified node includes the ability to insert.
	 * 
	 * @param node The node in question.
	 * @throws InsufficientPermissionException If the node is not insertable.
	 */
	public void assertInsertable(Node node) throws InsufficientPermissionException
	{
		NodePermission permission = getPermission(node);
		if (!permission.isInsertable())
		{
			throw new InsufficientPermissionExceptionImpl(node, NodePermission.INSERT, permission);
		}
	}

	/**
	 * Asserts that permission to the specified node includes the ability to mutate.
	 * 
	 * @param node The node in question.
	 * @throws InsufficientPermissionException If the node is not mutatable.
	 */
	public void assertMutatable(Node node) throws InsufficientPermissionException
	{
		NodePermission permission = getPermission(node);
		if (!permission.isMutatable())
		{
			throw new InsufficientPermissionExceptionImpl(node, NodePermission.MUTATE, permission);
		}
	}

	/**
	 * Determines whether or not the metaprogram with the specified ID cooperates with the current metaprogram.
	 * 
	 * @param id The ID of the metaprogram to check.
	 * @return <code>true</code> if the metaprograms cooperate; <code>false</code> if they do not.
	 */
	public boolean hasCooperation(int id)
	{
		if (this.dependencyManager == null || getCurrentMetaprogramId() == null)
			return true;

		if (this.dependencyManager.checkCooperation(getCurrentMetaprogramId(), id))
			return true;

		return false;
	}

	/**
	 * Asserts that the metaprogram with the specified ID cooperates with the current metaprogram.
	 * 
	 * @param id The ID of the metaprogram to check.
	 * @param node The node that the two metaprograms are modifying.
	 * @throws MetaprogramConflictException If the metaprogram with the specified ID does not cooperate with the current
	 *             metaprogram.
	 */
	public void assertCooperation(int id, Node node) throws MetaprogramConflictException
	{
		if (!hasCooperation(id))
		{
			if (LOGGER.isDebugEnabled())
			{
				LOGGER.debug("Attempted to assert cooperation between " + id + " and " + getCurrentMetaprogramId()
						+ " over node " + node.getUid() + " and failed.");
			}
			throw new MetaprogramConflictExceptionImpl(
					this.dependencyManager.getMetaprogramProfileByID(id).getAnchor(),
					this.dependencyManager.getMetaprogramProfileByID(getCurrentMetaprogramId()).getAnchor(), node);
		}
	}

	/**
	 * Creates a new meta-annotation metaprogram anchor. This functionality is provided here to prevent nodes from
	 * needing access to a factory. It is intended to be used by the {@link MetaAnnotationNode} when an anchor is
	 * required to support its annotation object.
	 * 
	 * @param node The node for which the anchor is being created.
	 * @return A new meta-annotation metaprogram anchor.
	 */
	public MetaAnnotationMetaprogramAnchorNode instantiateMetaAnnotationMetaprogramAnchor(Node node)
	{
		return this.instantiator.instantiateMetaAnnotationMetaprogramAnchor(node);
	}
	
	/**
	 * Instantiates a meta-annotation object for a meta-annotation node. This method is separated from the
	 * {@link MetaAnnotationNode} implementation to allow multiple invocations of the same meta-annotation class to
	 * share information about the structure of that meta-annotation declaration.
	 * 
	 * @param node The meta-annotation node for which to instantiate an object.
	 * @param listener The diagnostic listener to which to report errors.
	 * @return The resulting meta-annotation object.
	 * @throws MetaAnnotationInstantiationFailureException If the meta-annotation object cannot be instantiated or
	 *             configured correctly.
	 */
	public BsjMetaAnnotation instantiateMetaAnnotationObject(MetaAnnotationNode node,
			DiagnosticListener<BsjSourceLocation> listener) throws MetaAnnotationInstantiationFailureException
	{
		return this.instantiator.instantiateMetaAnnotationObject(node, listener);
	}

	/**
	 * Sets the toolkit that this node manager should use.
	 * 
	 * @param toolkit The toolkit to use.
	 */
	public void setToolkit(BsjToolkit toolkit)
	{
		this.instantiator.setToolkit(toolkit);
	}
}
