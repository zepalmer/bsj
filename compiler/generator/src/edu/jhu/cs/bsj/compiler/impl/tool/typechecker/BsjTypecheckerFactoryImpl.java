package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.typechecker.BsjTypechecker;
import edu.jhu.cs.bsj.compiler.tool.typechecker.BsjTypecheckerFactory;

public class BsjTypecheckerFactoryImpl implements BsjTypecheckerFactory
{
	private BsjToolkit toolkit;

	public BsjTypecheckerFactoryImpl(BsjToolkit toolkit)
	{
		super();
		this.toolkit = toolkit;
	}

	@Override
	public BsjTypechecker makeTypechecker(PackageNode rootPackage,
			DiagnosticListener<BsjSourceLocation> diagnosticListener)
	{
		TypecheckerManager manager = new TypecheckerManager(rootPackage, this.toolkit.getParser(),
				this.toolkit.getCompilationUnitLoadingInfoFactory().makeLoadingInfo(diagnosticListener), diagnosticListener);
		return new TypecheckerImpl(manager, this.toolkit.getParser());
	}
}
