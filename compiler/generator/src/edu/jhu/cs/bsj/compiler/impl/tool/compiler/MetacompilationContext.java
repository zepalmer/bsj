package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.util.Map;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.DependencyManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.extraction.ExplicitMetaprogramCompilationCache;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.BsjCompilerTask;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

public interface MetacompilationContext
{
	/**
	 * Obtains the object program's root package for the initial tree this compilation pass.
	 */
	public PackageNode getRootPackage();
	
    /**
     * A mapping from UIDs to nodes in the original AST (the one specified by loaded files before any metaprograms are
     * executed).  This map will be empty until the task that constructs it is executed.
     */
	public Map<Long,Node> getIdMap();
	
	/**
	 * Retrieves the toolkit which should be used to satisfy tool requirements.
	 * @return The toolkit to use.
	 */
	public BsjToolkit getToolkit();
	
	/**
	 * Retrieves the node manager used during metacompilation to control metaprogram execution.
	 * @return The node manager to use.
	 */
	public BsjNodeManager getNodeManager();
	
	/**
	 * Retrieves a diagnostic listener to which diagnostics can be reported.
	 * @return The diagnostic listener to use.
	 */
	public DiagnosticListener<BsjSourceLocation> getDiagnosticListener();
	
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
	
	/**
	 * Adds a source file to the list of serialized files.
	 * @param file The file to add.
	 */
	public void addSerializedFile(BsjFileObject file);

	/**
	 * Retrieves the compilation cache for explicit metaprograms.
	 * @return The explicit metaprogram compilation cache.
	 */
    public ExplicitMetaprogramCompilationCache getExplicitMetaprogramCompilationCache();
}
