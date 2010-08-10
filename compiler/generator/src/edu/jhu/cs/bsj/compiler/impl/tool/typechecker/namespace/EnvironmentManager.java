package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;

/**
 * This class manages the calculation and storage of environments in the type checker. An environment represents
 * namespace mappings on a per-node basis. This manager serves the function of a symbol table generator.
 * 
 * @author Zachary Palmer
 */
public class EnvironmentManager
{
	/**
	 * The node operation which calculates the environment for a node.
	 */
	private BsjNodeOperation<Void, Environment> environmentCalculatingOperation;

	/**
	 * Creates a new environment manager.
	 * 
	 * @param rootPackage The root package in the AST.
	 * @param listener The listener to which lookup and declaration errors should be reported.
	 * @param toolkit The typechecker toolkit to use to build elements.
	 */
	public EnvironmentManager(PackageNode rootPackage, DiagnosticListener<BsjSourceLocation> listener,
			CompilationUnitLoader loader,
			TypecheckerToolkit toolkit)
	{
		super();
		this.environmentCalculatingOperation = new EnvironmentCalculatingOperation(toolkit, loader, listener);
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
		return node.executeOperation(this.environmentCalculatingOperation, null);
	}
}
