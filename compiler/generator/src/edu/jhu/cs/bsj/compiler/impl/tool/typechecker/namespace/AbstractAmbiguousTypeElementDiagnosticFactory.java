package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.AmbiguousTypeNameDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.DeclaredTypeElementImpl;

public abstract class AbstractAmbiguousTypeElementDiagnosticFactory implements
		AmbiguousDiagnosticFactory<DeclaredTypeElementImpl<?>>
{
	public AbstractAmbiguousTypeElementDiagnosticFactory()
	{
		super();
	}

	@Override
	public AmbiguousTypeNameDiagnostic makeDiagnostic(String name,
			NamespaceEntry<? extends DeclaredTypeElementImpl<?>> entry, BsjSourceLocation sourceLocation)
	{
		List<NamedTypeDeclarationNode<?>> nodes = new ArrayList<NamedTypeDeclarationNode<?>>();
		for (DeclaredTypeElementImpl<?> element : entry.getIndicatorNodeMap().values())
		{
			nodes.add(element.getBackingNode());
		}
		return createDiagnostic(name, sourceLocation, nodes);
	}

	protected abstract AmbiguousTypeNameDiagnostic createDiagnostic(String name, BsjSourceLocation sourceLocation,
			List<NamedTypeDeclarationNode<?>> nodes);
}