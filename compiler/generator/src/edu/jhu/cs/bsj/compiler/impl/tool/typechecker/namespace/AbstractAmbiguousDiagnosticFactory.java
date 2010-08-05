package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.AmbiguousTypeNameDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.DeclaredTypeElementImpl;

public abstract class AbstractAmbiguousDiagnosticFactory implements AmbiguousDiagnosticFactory
{
	public AbstractAmbiguousDiagnosticFactory()
	{
		super();
	}

	@Override
	public AmbiguousTypeNameDiagnostic makeDiagnostic(String name, TypeNamespaceEntry entry, BsjSourceLocation sourceLocation)
	{
		if (entry.getTypes().size() > 1)
		{
			List<NamedTypeDeclarationNode<?>> nodes = new ArrayList<NamedTypeDeclarationNode<?>>();
			for (DeclaredTypeElementImpl<?> element : entry.getIndicatorNodeMap().values())
			{
				nodes.add(element.getBackingNode());
			}
			return createDiagnostic(name, sourceLocation, nodes);
		} else
		{
			return null;
		}
	}

	protected abstract AmbiguousTypeNameDiagnostic createDiagnostic(String name,
			BsjSourceLocation sourceLocation, List<NamedTypeDeclarationNode<?>> nodes);
}