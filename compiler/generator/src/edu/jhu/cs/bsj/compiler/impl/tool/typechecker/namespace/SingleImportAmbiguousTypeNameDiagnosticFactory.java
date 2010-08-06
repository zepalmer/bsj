package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.typechecker.SingleImportAmbiguousTypeNameDiagnosticImpl;

public class SingleImportAmbiguousTypeNameDiagnosticFactory extends AbstractAmbiguousTypeElementDiagnosticFactory
{
	@Override
	protected SingleImportAmbiguousTypeNameDiagnosticImpl createDiagnostic(String name,
			BsjSourceLocation sourceLocation, List<NamedTypeDeclarationNode<?>> nodes)
	{
		return new SingleImportAmbiguousTypeNameDiagnosticImpl(sourceLocation, name, nodes);
	}
}
