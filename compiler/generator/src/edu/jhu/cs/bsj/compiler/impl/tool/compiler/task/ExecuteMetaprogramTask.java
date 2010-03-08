package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.util.Iterator;

import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.NodePermission;
import edu.jhu.cs.bsj.compiler.ast.node.BlockNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.PermissionPolicyManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;

/**
 * This metacompilation task attempts to execute a single metaprogram. If a metaprogram is available for execution, it
 * will be executed and this task will re-enqueue itself. Otherwise, this task will create a serialization task for each
 * compilation unit in the package hierarchy.
 * 
 * @author Zachary Palmer
 */
public class ExecuteMetaprogramTask extends AbstractBsjCompilerTask
{
	public ExecuteMetaprogramTask()
	{
		super(TaskPriority.EXECUTE);
	}

	@Override
	public void execute(MetacompilationContext context) throws IOException
	{
		MetaprogramProfile profile = context.getDependencyManager().getNextMetaprogram();
		if (profile == null)
		{
			finishMetaprogramExecutionPhase(context);
		} else
		{
			execute(profile, context);
		}
	}

	private void finishMetaprogramExecutionPhase(MetacompilationContext context)
	{
		Iterator<CompilationUnitNode> it = context.getRootPackage().getRecursiveCompilationUnitIterator();
		while (it.hasNext())
		{
			CompilationUnitNode node = it.next();
			// TODO: skip nodes which represent binary files
			context.registerTask(new SourceSerializationTask(node));
		}
	}

	private void execute(MetaprogramProfile profile, MetacompilationContext context)
	{
		// Set up the permission policy manager for this metaprogram
		PermissionPolicyManager policyManager = createPermissionPolicyManager(profile, context.getRootPackage());
		context.getNodeManager().setPermissionPolicyManager(policyManager);

		// Run the metaprogram
		profile.getMetaprogram().execute();
		context.getDependencyManager().notifyExecuted(profile);

		// Release the policy manager
		context.getNodeManager().setPermissionPolicyManager(null);

		// Have the metaprogram replace itself with its replacement node
		// TODO: what kind of policy should we put into place for this?  can a read-only metaprogram replace itself?
		Node replacement = profile.getAnchor().getReplacement();
		profile.getAnchor().getParent().replace(profile.getAnchor(), replacement);

		// Schedule a task to walk over the replacement node and extract all of its descendent metaprograms
		context.registerTask(new ExtractMetaprogramsTask(replacement));

		// Re-enqueue this task so we can execute the next metaprogram when the time comes (which is probably right now)
		context.registerTask(this);
	}

	/**
	 * Creates an appropriate permission policy manager for the given metaprogram.
	 * 
	 * @param profile The profile of the metaprogram.
	 * @param rootPackage The root package for the policy manager.
	 * @return The policy manager for that metaprogram.
	 */
	private PermissionPolicyManager createPermissionPolicyManager(MetaprogramProfile profile, PackageNode rootPackage)
	{
		PermissionPolicyManager policyManager = new PermissionPolicyManager(rootPackage);

		if (profile.getLocalMode() == MetaprogramLocalMode.INSERT
				|| profile.getLocalMode() == MetaprogramLocalMode.MUTATE)
		{
			NodePermission permission;
			if (profile.getLocalMode() == MetaprogramLocalMode.INSERT)
			{
				permission = NodePermission.INSERT;
			} else if (profile.getLocalMode() == MetaprogramLocalMode.MUTATE)
			{
				permission = NodePermission.MUTATE;
			} else
			{
				throw new IllegalStateException("Inconsistent code structure - unknown local mode "
						+ profile.getLocalMode());
			}
			
			boolean found = false;
			Node node = profile.getAnchor();
			while (node != null)
			{
				if (node instanceof CompilationUnitNode || node instanceof TypeDeclarationNode ||
						node instanceof BlockNode)
				{
					policyManager.addThreshold(node, permission);
					found = true;
					break;
				}
				node = node.getParent();
			}
			if (!found)
			{
				// Then we never found a suitable parent.  Assume that we're detached from the root package.
				policyManager.addThreshold(profile.getAnchor().getFurthestAncestor(), NodePermission.MUTATE);
			}
		} else if (profile.getLocalMode() == MetaprogramLocalMode.FULL_MUTATE)
		{
			// Find the nearest compilation unit and give it mutate access
			CompilationUnitNode compilationUnitNode = profile.getAnchor().getNearestAncestorOfType(
					CompilationUnitNode.class);
			if (compilationUnitNode != null)
			{
				policyManager.addThreshold(compilationUnitNode, NodePermission.MUTATE);
			} else
			{
				// There is no enclosing compilation unit? Assume we're detached from the root package.
				policyManager.addThreshold(profile.getAnchor().getFurthestAncestor(), NodePermission.MUTATE);
			}
		}

		if (profile.getPackageMode() == MetaprogramPackageMode.INSERT)
		{
			policyManager.addThreshold(rootPackage, NodePermission.INSERT);
		}
		
		return policyManager;
	}
}
