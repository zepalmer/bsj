package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.ast.PackageNodeManager;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;

public class CompilationUnitLoaderImpl implements CompilationUnitLoader
{
	/** The package node manager to back the requested operations. */
	private PackageNodeManager packageNodeManager;
	/** The diagnostic listener to which errors will be reported. */
	private DiagnosticListener<BsjSourceLocation> diagnosticListener;
	
	public CompilationUnitLoaderImpl(PackageNodeManager packageNodeManager,
			DiagnosticListener<BsjSourceLocation> diagnosticListener)
	{
		super();
		this.packageNodeManager = packageNodeManager;
		this.diagnosticListener = diagnosticListener;
	}

	@Override
	public CompilationUnitNode load(PackageNode packageNode, String name)
	{
		return this.packageNodeManager.load(packageNode, name, this.diagnosticListener);
	}

	@Override
	public void loadAll(PackageNode packageNode)
	{
		for (String name : this.packageNodeManager.listCompilationUnitNames(packageNode, false))
		{
			load(packageNode, name);
		}
	}
}
