package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.HashMap;
import java.util.Map;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;

/**
 * Calculates the environment for a specific node. The environment for a node contains all of the names which are in
 * scope <i>before</i> that node is taken into account. The environment for a variable declaration node, for instance,
 * does not include the effect of that variable declaration. The environment for a compilation unit node is empty.
 * <p/>
 * This operation caches its results in order to improve performance. As a result, it must not be used after any part of
 * the underlying AST changes.
 * 
 * @author Zachary Palmer
 */
public class EnvironmentCalculatingOperation extends BsjDefaultNodeOperation<Void, Environment>
{
	/** A mapping used to store cached environment calculations. */
	private Map<Node, Environment> environmentCache;
	/** An operation which identifies the environment parent nodes for given nodes. */
	private ParentEnvironmentNodeIdentifyingOperation locator;
	/** An operation which applies the changes from a given node onto its environment child. */
	private EnvironmentModifyingNodeOperation modifier;

	/**
	 * The diagnostic listener to which errors are reported.
	 */
	private DiagnosticListener<BsjSourceLocation> listener;

	public EnvironmentCalculatingOperation(TypecheckerToolkit toolkit, CompilationUnitLoader loader,
			DiagnosticListener<BsjSourceLocation> listener)
	{
		this.listener = listener;

		this.environmentCache = new HashMap<Node, Environment>();
		this.locator = new ParentEnvironmentNodeIdentifyingOperation();
		this.modifier = new EnvironmentModifyingNodeOperation(toolkit, loader, this.listener);
	}

	@Override
	public Environment executeDefault(Node node, Void p)
	{
		Environment environment = this.environmentCache.get(node);
		if (environment == null)
		{
			// *** Actually calculate the environment.

			// Find the node which dictates which environment this node will have
			Node parentEnvironmentNode = node.executeOperation(this.locator, null);

			if (parentEnvironmentNode == null)
			{
				// There is no parent environment; start a fresh one
				environment = new Environment(NamespaceMap.makeType(null, this.listener, false),
						NamespaceMap.makeMethod(null, this.listener, false), NamespaceMap.makeVariable(null,
								this.listener, false));
				environment.lock();
			} else
			{
				// Find the parent environment
				Environment parentEnvironment = parentEnvironmentNode.executeOperation(this, null);

				// Apply changes to its environment as necessary
				environment = parentEnvironmentNode.executeOperation(this.modifier, parentEnvironment, node);

				// Lock the environment to ensure that it does not change
				environment.lock();

				// Reduce the environment if possible
				environment = environment.reduce(parentEnvironment);
			}

			// Store the result
			this.environmentCache.put(node, environment);
		}
		return environment;
	}
}
