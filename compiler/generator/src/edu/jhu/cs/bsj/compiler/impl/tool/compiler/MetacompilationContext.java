package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.DependencyManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.BsjCompilerTask;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileManager;

public interface MetacompilationContext
{
	/**
	 * Obtains the object program's root package for this compilation pass.
	 */
	public PackageNode getRootPackage();
	
	/**
	 * Retrieves the factory which should be used to create new nodes.
	 * @return A node factory.
	 */
	public BsjNodeFactory getFactory();
	
	/**
	 * Retrieves the file manager that the task should use to find files.
	 * @return The file manager.
	 */
	public BsjFileManager getFileManager();
	
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
