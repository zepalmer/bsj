package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.ArrayList;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.AmbiguousTypeNameDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.typechecker.SingleImportAmbiguousTypeNameDiagnosticImpl;

public class SingleImportAmbiguousTypeNameDiagnosticFactory implements AmbiguousDiagnosticFactory
{
	@Override
	public AmbiguousTypeNameDiagnostic makeDiagnostic(String name, TypeNamespaceEntry entry,
			BsjSourceLocation sourceLocation)
	{
		if (entry.getTypes().size() > 1)
		{
			return new SingleImportAmbiguousTypeNameDiagnosticImpl(sourceLocation, name,
					new ArrayList<NamedTypeDeclarationNode<?>>(entry.getIndicatorNodeMap().values()));
		} else
		{
			return null;
		}
	}
}
