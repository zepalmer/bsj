package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.util.Iterator;

import javax.tools.Diagnostic.Kind;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.NodePermission;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramDetectedErrorException;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.BlockNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnhancedForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.CountingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramExceptionDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramExecutionFailureDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.Metaprogram;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.PermissionPolicyManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.compiler.tool.data.BsjThreadLocalData;

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
		CountingDiagnosticProxyListener<BsjSourceLocation> listener = new CountingDiagnosticProxyListener<BsjSourceLocation>(
				context.getDiagnosticListener());
		MetaprogramProfile<?, ?> profile = context.getDependencyManager().getNextMetaprogram(listener);
		if (listener.getCount(Kind.ERROR) > 0)
		{
			return;
		}

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
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("No metaprograms left to run.  Adding cleanup tasks.");
		}
		Iterator<CompilationUnitNode> it = context.getRootPackage().getRecursiveCompilationUnitIterator();
		while (it.hasNext())
		{
			CompilationUnitNode node = it.next();
			if (!node.isBinary())
			{
				context.registerTask(new ReplaceCodeLiteralsTask(node));
				context.registerTask(new StripBsjNodesTask(node));
			}
		}
	}

	private <A extends MetaprogramAnchorNode<?>> void execute(MetaprogramProfile<?, ?> profile,
			MetacompilationContext context)
	{
		// Log metaprogram execution
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Executing metaprogram " + profile.getMetaprogram().getID());
			CompilationUnitNode compilationUnitNode = profile.getAnchor().getNearestAncestorOfType(
					CompilationUnitNode.class);
			if (compilationUnitNode == null)
			{
				LOGGER.trace("Metaprogram anchor is detached!");
			} else
			{
				LOGGER.trace("Metaprogram's source unit currently looks like this:\n"
						+ compilationUnitNode.executeOperation(context.getToolkit().getSerializer(), null));
			}
		}

		// Set up the permission policy manager and dependency manager for this metaprogram
		PermissionPolicyManager policyManager = createPermissionPolicyManager(profile, context.getRootPackage());
		context.getNodeManager().pushPermissionPolicyManager(policyManager);
		context.getNodeManager().pushCurrentMetaprogram(profile);
		context.getNodeManager().setDependencyManager(context.getDependencyManager());
		BsjServiceRegistry.getThreadLocalData().push(BsjThreadLocalData.Element.CONTEXT, profile.getContext());
		BsjServiceRegistry.getThreadLocalData().push(BsjThreadLocalData.Element.NODE_FACTORY,
				profile.getContext().getFactory());

		// Run the metaprogram
		BsjDiagnostic diagnostic = doExecute(profile);

		// Release the managers
		context.getNodeManager().popPermissionPolicyManager();
		context.getNodeManager().popCurrentMetaprogram();
		BsjServiceRegistry.getThreadLocalData().pop(BsjThreadLocalData.Element.CONTEXT);
		BsjServiceRegistry.getThreadLocalData().pop(BsjThreadLocalData.Element.NODE_FACTORY);

		// Respond to error as necessary
		if (diagnostic != null)
		{
			context.getDiagnosticListener().report(diagnostic);
		}

		// Notify the dependency manager that execution has finished
		context.getDependencyManager().notifyExecuted(profile);
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Metaprogram " + profile.getMetaprogram().getID() + " execution complete.");
			CompilationUnitNode compilationUnitNode = profile.getAnchor().getNearestAncestorOfType(
					CompilationUnitNode.class);
			if (compilationUnitNode == null)
			{
				LOGGER.trace("Metaprogram anchor is detached!");
			} else
			{
				LOGGER.trace("Metaprogram's source unit currently looks like this:\n"
						+ compilationUnitNode.executeOperation(context.getToolkit().getSerializer(), null));
			}
		}

		// Have the metaprogram replace itself with its replacement node
		// TODO: what kind of policy should we put into place for this? can a read-only metaprogram replace itself?
		Node replacement = profile.getContext().getReplacement();
		if (replacement != null)
		{
			profile.getContext().getAnchor().getParent().replace(profile.getContext().getAnchor(), replacement);
		}

		// Pass the affected part of the AST back to allow name analysis, etc.
		// TODO: make the following a little bit more palatable by only analyzing those trees that changed
		Node target;
		if (replacement != null)
		{
			target = replacement.getFurthestAncestor();
		} else
		{
			target = profile.getAnchor().getFurthestAncestor();
		}
		context.registerTask(new InstantiateMetaAnnotationObjectTask(target, new InjectionInfo(profile, true)));

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
	private PermissionPolicyManager createPermissionPolicyManager(MetaprogramProfile<?, ?> profile,
			PackageNode rootPackage)
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Establishing permissions for metaprogram " + profile.getMetaprogram().getID());
		}

		PermissionPolicyManager policyManager = new PermissionPolicyManager(rootPackage);

		// If we're detached from the root package, the user can do anything
		if (profile.getAnchor().getRootPackage() == null)
		{
			policyManager.addThreshold(profile.getAnchor().getFurthestAncestor(), NodePermission.MUTATE);
			return policyManager;
		}

		// Build local profile rules as per the BSJ language spec
		boolean found = false;
		if (profile.getLocalMode() == MetaprogramLocalMode.INSERT
				|| profile.getLocalMode() == MetaprogramLocalMode.MUTATE)
		{
			// Figure out which permission corresponds to our mode
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

			Node node = profile.getAnchor();
			Node targetNode = null; // this is the node to which permission will be granted
			if (node instanceof MetaAnnotationMetaprogramAnchorNode)
			{
				// * If the metaprogram’s anchor is a meta-annotation (§5), then
				MetaAnnotationMetaprogramAnchorNode anchorNode = (MetaAnnotationMetaprogramAnchorNode) node;

				// Find the node above the meta-annotation list and (possibly) the modifiers node
				node = anchorNode.getParent();
				while (node instanceof MetaAnnotationNode || node instanceof MetaAnnotationListNode
						|| node instanceof ModifiersNode)
				{
					node = node.getParent();
				}
				// The field "node" should now contain the node that the meta-annotation annotates

				if (node instanceof PackageDeclarationNode)
				{
					// + If the meta-annotation annotates a package declaration, then the metaprogram is given
					// permission to that package declaration.
					targetNode = node;
				} else if (node instanceof TypeDeclarationNode)
				{
					// + If the meta-annotation annotates a type declaration, then the metaprogram is given permission
					// to that type declaration.
					targetNode = node;
				} else if (node instanceof FieldDeclarationNode || node instanceof MethodDeclarationNode
						|| node instanceof ConstructorDeclarationNode || node instanceof InitializerDeclarationNode)
				{
					// + If the meta-annotation annotates a field, method, constructor declaration, static initializer
					// or instance initializer, then the metaprogram is given Insert permission to the type declaration
					// which encloses that node.
					targetNode = node.getNearestAncestorOfType(TypeDeclarationNode.class);
				} else if (node instanceof LocalVariableDeclarationNode || node instanceof StatementNode)
				{
					// + If the meta-annotation annotates a local variable declaration or statement, then
					BlockStatementListNode enclosingBlockStatementList = node.getNearestAncestorOfType(BlockStatementListNode.class);
					if (enclosingBlockStatementList != null
							&& (enclosingBlockStatementList.getParent() instanceof MethodDeclarationNode || enclosingBlockStatementList.getParent() instanceof ConstructorDeclarationNode))
					{
						// . If the local variable declaration or statement is contained within a block of statements
						// which serves as the body for a method or constructor declaration, then the metaprogram is
						// given permission to that declaration.
						targetNode = enclosingBlockStatementList.getParent();
					} else if (node.getParent() instanceof BlockNode
							&& node.getParent().getParent() instanceof ForInitializerNode
							&& node.getParent().getParent().getParent() instanceof ForLoopNode)
					{
						// . If the local variable declaration or statement is contained within the header for a
						// standard for-loop, then the metaprogram is given permission to the for-loop.
						targetNode = node.getParent().getParent().getParent();
					} else
					{
						// . Otherwise, the metaprogram is given permission to the block of statements which encloses
						// the local variable declaration or statement.
						targetNode = enclosingBlockStatementList.getParent();
					}
				} else if (node instanceof VariableNode)
				{
					// + If the meta-annotation annotates a parameter, then
					VariableNode variableNode = (VariableNode) node;
					if (variableNode.getParent() instanceof CatchNode)
					{
						// . If the parameter is a parameter to a catch block, then the metaprogram is granted
						// permission to the list of catch blocks.
						targetNode = variableNode.getParent().getParent();
					} else if (variableNode.getParent() instanceof EnhancedForLoopNode)
					{
						// . If the parameter is a parameter to an enhanced for loop, then the metaprogram is granted
						// permission to the enhanced for loop.
						targetNode = variableNode.getParent();
					} else if (variableNode.getParent() instanceof VariableListNode
							&& (variableNode.getParent().getParent() instanceof MethodDeclarationNode || variableNode.getParent().getParent() instanceof ConstructorDeclarationNode))
					{
						// . If the parameter is a parameter in the formal parameter list of a method or constructor
						// declaration, then the metaprogram is granted permission to that method or constructor
						// declaration.
						targetNode = variableNode.getParent().getParent();
					}
				} else if (node instanceof MetaAnnotationMetaAnnotationValueNode)
				{
					// + If the metaprogram’s anchor is a meta-annotation which exists as an element value in another
					// meta-annotation, it is given permission to the parent meta-annotation.
					targetNode = node.getNearestAncestorOfType(MetaAnnotationNode.class);
				}
			} else
			{
				while (node != null)
				{
					// * If the metaprogram’s anchor is in the top level of a compilation unit, it is given permission
					// to
					// that compilation unit.
					// * If the metaprogram’s anchor is a member of a type declaration, it is given permission to the
					// type
					// declaration.
					if (node instanceof CompilationUnitNode || node instanceof TypeDeclarationNode)
					{
						targetNode = node;
						break;
					}
					// * If the metaprogram’s anchor is a member of a block of statements, then
					if (node instanceof BlockStatementNode && (node.getParent() instanceof BlockStatementListNode))
					{
						BlockStatementListNode listNode = (BlockStatementListNode) (node.getParent());
						if (listNode.getParent() instanceof BlockNode)
						{
							BlockNode block = (BlockNode) (listNode.getParent());
							// + If the block serves as the body for a method or constructor declaration, then the
							// metaprogram is given permission to that declaration.
							if (block.getParent() instanceof MethodDeclarationNode
									|| block.getParent() instanceof ConstructorDeclarationNode)
							{
								targetNode = block.getParent();
							} else
							{
								// + Otherwise, the metaprogram is given Insert permission to the block of statements.
								targetNode = block;
							}
							break;
						}
					}
					node = node.getParent();
				}
			}
			if (targetNode != null)
			{
				if (LOGGER.isTraceEnabled())
				{
					LOGGER.trace("Granting " + permission + " permission to metaprogram "
							+ profile.getMetaprogram().getID() + " for " + targetNode.getClass().getSimpleName()
							+ " node at " + targetNode.getStartLocation());
				}
				policyManager.addThreshold(targetNode, permission);
				found = true;
			}
		} else if (profile.getLocalMode() == MetaprogramLocalMode.FULL_MUTATE)
		{
			// Find the nearest compilation unit and give it mutate access
			CompilationUnitNode compilationUnitNode = profile.getAnchor().getNearestAncestorOfType(
					CompilationUnitNode.class);
			if (compilationUnitNode != null)
			{
				if (LOGGER.isTraceEnabled())
				{
					LOGGER.trace("Granting " + NodePermission.MUTATE + " permission to metaprogram "
							+ profile.getMetaprogram().getID() + " for "
							+ compilationUnitNode.getClass().getSimpleName() + " node at "
							+ compilationUnitNode.getStartLocation());
				}
				policyManager.addThreshold(compilationUnitNode, NodePermission.MUTATE);
				found = true;
			}
		}

		if (!found)
		{
			// Then we never found a suitable parent.
			throw new IllegalStateException("Provided anchor at " + profile.getAnchor().getStartLocation()
					+ " for which no parent could be found in " + profile.getLocalMode() + " mode");
		}

		// Now address package mode. This is a bit easier
		if (profile.getPackageMode() == MetaprogramPackageMode.INSERT)
		{
			if (LOGGER.isTraceEnabled())
			{
				LOGGER.trace("Granting " + NodePermission.INSERT + " permission to metaprogram "
						+ profile.getMetaprogram().getID() + " for " + rootPackage.getClass().getSimpleName()
						+ " node at " + rootPackage.getStartLocation());
			}
			policyManager.addThreshold(rootPackage, NodePermission.INSERT);
		}

		return policyManager;
	}

	/**
	 * Performs actual metaprogram execution. This method calls the metaprogram's execute method and responds to runtime
	 * exceptions by returning an appropriate diagnostic.
	 * 
	 * @param profile The profile of the metaprogram to execute.
	 * @return A diagnostic if one should be reported or <code>null</code> if everything went fine.
	 */
	private <A extends MetaprogramAnchorNode<B>, B extends Node> BsjDiagnostic doExecute(
			MetaprogramProfile<A, B> profile)
	{
		Context<A, B> context = profile.getContext();
		Metaprogram<A, B> metaprogram = profile.getMetaprogram();
		if (context == null)
		{
			throw new IllegalStateException("Attempted to execute metaprogram profile with null context!");
		}
		if (metaprogram == null)
		{
			throw new IllegalStateException("Attempted to execute metaprogram profile with null metaprogram!");
		}

		BsjSourceLocation sourceLocation = profile.getLocation();
		try
		{
			metaprogram.execute(context);
		} catch (MetaprogramDetectedErrorException mdee)
		{
			return mdee.getDiagnostic(sourceLocation);
		} catch (MetaprogramExecutionFailureException mefe)
		{
			return new MetaprogramExecutionFailureDiagnosticImpl(sourceLocation, mefe);
		} catch (Exception e)
		{
			// The metaprogram threw something unexpected (like NullPointerException); handle it.
			return new MetaprogramExceptionDiagnosticImpl(sourceLocation, e);
		}

		return null;
	}
}
