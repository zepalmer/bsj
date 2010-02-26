package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.DependencyManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.BsjCompilerTask;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;

public interface MetacompilationContext
{
	/**
	 * Obtains the object program's root package for this compilation pass.
	 */
	public PackageNode getRootPackage();
	
	/**
	 * Retrieves the toolkit which should be used to satisfy tool requirements.
	 * @return The toolkit to use.
	 */
	public BsjToolkit getToolkit();
	
	/**
	 * Retrieves a diagnostic listener to which diagnostics can be reported.
	 * @return The diagnostic listener to use.
	 */
	public DiagnosticListener<? super JavaFileObject> getDiagnosticListener();
	
	/**
	 * Retrieves the dependency manager to use.
	 * @return The dependency manager which manages metaprograms for this compilation.
	 */
	public DependencyManager getDependencyManager();
	
	/**
	 * Registers a new task for execution.
	 * @param task The task to execute.
	 */
	public void registerTask(BsjCompilerTask task);
}
