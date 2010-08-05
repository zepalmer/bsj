package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.EnvironmentManager;

/**
 * This class provides common state information for modeling types and elements in the typechecker.
 * @author Zachary Palmer
 */
public class TypecheckerModelManager
{
	/** The root package. */
	private PackageNode rootPackage;
	/** This manager's toolkit. */
	private TypecheckerToolkit toolkit;
	/** The environment manager for this typechecker model. */
	private EnvironmentManager environmentManager;
	
	/**
	 * Creates a new manager.
	 * @param rootPackage The root package over which type checking will be performed.
	 * @param diagnosticListener The diagnostic listener to which to report errors.
	 */
	public TypecheckerModelManager(PackageNode rootPackage, DiagnosticListener<BsjSourceLocation> diagnosticListener)
	{
		super();
		this.rootPackage = rootPackage;
		
		this.toolkit = new TypecheckerToolkit(this);
		this.environmentManager = new EnvironmentManager(this.rootPackage, diagnosticListener, this.toolkit);
	}

	public PackageNode getRootPackage()
	{
		return rootPackage;
	}

	public TypecheckerToolkit getToolkit()
	{
		return toolkit;
	}
	
	public EnvironmentManager getEnvironmentManager()
	{
		return environmentManager;
	}
}
