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
	public DiagnosticListener<BsjSourceLocation> getDiagnosticListener()
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
    public Map<Long, Node> getIdMap()
    {
        return this.context.getIdMap();
    }

    @Override
    public ExplicitMetaprogramCompilationCache getExplicitMetaprogramCompilationCache()
    {
        return this.context.getExplicitMetaprogramCompilationCache();
    }
}
