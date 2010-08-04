package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.ArrayList;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.AmbiguousTypeNameDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.typechecker.OnDemandImportAmbiguousTypeNameDiagnosticImpl;

public class OnDemandImportAmbiguousTypeNameDiagnosticFactory implements AmbiguousDiagnosticFactory
{
	@Override
	public AmbiguousTypeNameDiagnostic makeDiagnostic(String name, TypeNamespaceEntry entry,
			BsjSourceLocation sourceLocation)
	{
		if (entry.getTypes().size() > 1)
		{
			return new OnDemandImportAmbiguousTypeNameDiagnosticImpl(sourceLocation, name,
					new ArrayList<NamedTypeDeclarationNode<?>>(entry.getIndicatorNodeMap().values()));
		} else
		{
			return null;
		}
	}
}
