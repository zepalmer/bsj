package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.CompilationUnitLoadingInfoImpl;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoadingInfo;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoadingInfoFactory;

public class CompilationUnitLoadingInfoFactoryImpl implements CompilationUnitLoadingInfoFactory
{
	public CompilationUnitLoadingInfoFactoryImpl()
	{
		super();
	}

	@Override
	public CompilationUnitLoadingInfo makeLoadingInfo(DiagnosticListener<BsjSourceLocation> diagnosticListener)
	{
		return new CompilationUnitLoadingInfoImpl(diagnosticListener);
	}
}
