package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.HashMap;
import java.util.Map;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;

/**
 * This class manages the calculation and storage of environments in the type checker. An environment represents
 * namespace mappings on a per-node basis. This manager serves the function of a symbol table generator.
 * 
 * @author Zachary Palmer
 */
public class EnvironmentManager
{
	/**
	 * The mapping which relates nodes to their environments. More specifically, each node is mapped to the base
	 * environment which is applicable to their children. A compilation unit's environment, for instance, would include
	 * the type names introduced by its import nodes; a method body's environment would include the variable names
	 * introduced by its parameters but not the variable names introduced by its local variable declarations (because
	 * those declarations are children of the method body). Leaves will tend to use the same environment as their
	 * parents. If a name must be resolved, the node in which that name appears uses its own environment to resolve the
	 * name.
	 */
	private Map<Node, Environment> environmentMap;
	/**
	 * The node operation which permits the population of the environment map.
	 */
	private BsjNodeOperation<?, ?> environmentMapPopulatingOperation;

	/**
	 * Creates a new environment manager.
	 * 
	 * @param rootPackage The root package in the AST.
	 * @param listener The listener to which lookup and declaration errors should be reported.
	 * @param toolkit The typechecker toolkit to use to build elements.
	 */
	public EnvironmentManager(PackageNode rootPackage, DiagnosticListener<BsjSourceLocation> listener,
			TypecheckerToolkit toolkit)
	{
		super();
		this.environmentMap = new HashMap<Node, Environment>();
		this.environmentMapPopulatingOperation = new EnvironmentBuildingNodeOperation(this.environmentMap, rootPackage,
				toolkit, listener);
	}

	/**
	 * Retrieves an environment corresponding to the specified node. Package nodes will never have a corresponding
	 * environment. If the environment for this node has not yet been calculated, this method will lazily construct it.
	 * 
	 * @param node The node in question.
	 * @return The environment to use (or <code>null</code> if the node is a package node).
	 */
	public Environment getEnvironment(Node node)
	{
		if (node instanceof PackageNode)
		{
			return null;
		}

		Environment ret = environmentMap.get(node);
		if (ret == null)
		{
			ret = calculateEnvironment(node);
			environmentMap.put(node,ret);
		}
		return ret;
	}
	
	/**
	 * Calculates the environment for the specified node.
	 * @param node The node for which to calculate an environment.
	 * @return The resulting environment (or <code>null</code> if the node is a package node).
	 */
	public Environment calculateEnvironment(Node node)
	{
		
	}
}
