package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.EnvironmentManager;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;

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
	/** The compilation unit loader to use. */
	private CompilationUnitLoader loader;
	/** The environment manager for this typechecker model. */
	private EnvironmentManager environmentManager;
	
	/**
	 * Creates a new manager.
	 * @param rootPackage The root package over which type checking will be performed.
	 * @param diagnosticListener The diagnostic listener to which to report errors.
	 */
	public TypecheckerModelManager(PackageNode rootPackage, CompilationUnitLoader loader, DiagnosticListener<BsjSourceLocation> diagnosticListener)
	{
		super();
		this.rootPackage = rootPackage;
		this.loader = loader;
		
		this.toolkit = new TypecheckerToolkit(this, loader);
		this.environmentManager = new EnvironmentManager(this.rootPackage, diagnosticListener, this.loader, this.toolkit);
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
