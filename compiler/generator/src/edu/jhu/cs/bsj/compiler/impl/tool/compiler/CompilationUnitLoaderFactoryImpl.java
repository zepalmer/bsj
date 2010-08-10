package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.CompilationUnitLoaderImpl;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoaderFactory;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;

public class CompilationUnitLoaderFactoryImpl implements CompilationUnitLoaderFactory
{
	private BsjToolkit toolkit;
	private BsjNodeManager nodeManager;

	public CompilationUnitLoaderFactoryImpl(BsjToolkit toolkit, BsjNodeManager nodeManager)
	{
		super();
		this.toolkit = toolkit;
		this.nodeManager = nodeManager;
	}

	@Override
	public CompilationUnitLoader makeLoader(DiagnosticListener<BsjSourceLocation> diagnosticListener)
	{
		return new CompilationUnitLoaderImpl(this.toolkit, this.nodeManager, diagnosticListener);
	}
}
