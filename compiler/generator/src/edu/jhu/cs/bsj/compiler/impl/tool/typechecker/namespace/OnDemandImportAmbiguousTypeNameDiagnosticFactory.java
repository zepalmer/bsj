package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.typechecker.OnDemandImportAmbiguousTypeNameDiagnosticImpl;

public class OnDemandImportAmbiguousTypeNameDiagnosticFactory extends AbstractAmbiguousTypeElementDiagnosticFactory
{
	protected OnDemandImportAmbiguousTypeNameDiagnosticImpl createDiagnostic(String name,
			BsjSourceLocation sourceLocation, List<NamedTypeDeclarationNode<?>> nodes)
	{
		return new OnDemandImportAmbiguousTypeNameDiagnosticImpl(sourceLocation, name, nodes);
	}
}
