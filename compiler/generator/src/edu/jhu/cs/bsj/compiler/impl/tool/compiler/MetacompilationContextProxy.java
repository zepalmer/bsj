package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.DependencyManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.BsjCompilerTask;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

/**
 * This proxy class refers all calls to a backing context.  Subclasses may override portions of the functionality to
 * create a customized proxy.
 * @author Zachary Palmer
 */
public class MetacompilationContextProxy implements MetacompilationContext
{
	/**
	 * The backing context for this proxy.
	 */
	private MetacompilationContext context;
	
	public MetacompilationContextProxy(MetacompilationContext context)
	{
		super();
		this.context = context;
	}

	@Override
	public void addSerializedFile(BsjFileObject file)
	{
		this.context.addSerializedFile(file);
	}

	@Override
	public DependencyManager getDependencyManager()
	{
		return this.context.getDependencyManager();
	}

	@Override
	public DiagnosticListener<? super JavaFileObject> getDiagnosticListener()
	{
		return this.context.getDiagnosticListener();
	}

	@Override
	public BsjNodeManager getNodeManager()
	{
		return this.context.getNodeManager();
	}

	@Override
	public PackageNode getRootPackage()
	{
		return this.context.getRootPackage();
	}

	@Override
	public BsjToolkit getToolkit()
	{
		return this.context.getToolkit();
	}

	@Override
	public void registerTask(BsjCompilerTask task)
	{
		this.context.registerTask(task);
	}

	@Override
	public boolean addObservedAnchor(MetaprogramAnchorNode<?> anchor)
	{
		return this.context.addObservedAnchor(anchor);
	}
}
