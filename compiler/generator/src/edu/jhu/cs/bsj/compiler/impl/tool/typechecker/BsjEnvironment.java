package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.EnvironmentManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.MethodNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.TypeNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.VariableNamespaceMap;

/**
 * Objects of this class act as an environment for the BSJ type checker.  In addition to (lazily) providing access to
 * the namespaces of the associated node, a BSJ environment maintains other environmental variables established by the
 * BSJ language specification.
 * @author Zachary Palmer
 */
public class BsjEnvironment
{
	// TODO: add variables for the code literal mappings of C, R, and T
	
	/** The node for which the environment should be established. */
	private Node node;
	/** The environment manager that will be used to satisfy requests. */
	private EnvironmentManager manager;
	
	public BsjEnvironment(Node node, EnvironmentManager manager)
	{
		super();
		this.node = node;
		this.manager = manager;
	}
	
	/**
	 * Retrieves the type namespace from this environment.
	 */
	public TypeNamespaceMap getTypeNamespaceMap()
	{
		return this.manager.getTypeNamespace(this.node);
	}
	
	/**
	 * Retrieves the method namespace from this environment.
	 */
	public MethodNamespaceMap getMethodNamespaceMap()
	{
		return this.manager.getMethodNamespace(this.node);
	}
	
	/**
	 * Retrieves the variable namespace from this environment.
	 */
	public VariableNamespaceMap getVariableNamespaceMap()
	{
		return this.manager.getVariableNamespace(this.node);
	}
}
