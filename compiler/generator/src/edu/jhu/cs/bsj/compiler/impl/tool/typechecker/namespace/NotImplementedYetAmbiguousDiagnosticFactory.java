package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.AmbiguousTypeNameDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.NotImplementedYetException;

/**
 * This factory is intended to be used in cases in which ambiguity handling has not yet been written.  All use of this
 * class should eventually be eliminated.
 * @author Zachary Palmer
 */
public class NotImplementedYetAmbiguousDiagnosticFactory extends AbstractAmbiguousDiagnosticFactory
{
	@Override
	protected AmbiguousTypeNameDiagnostic createDiagnostic(String name, BsjSourceLocation sourceLocation,
			List<NamedTypeDeclarationNode<?>> nodes)
	{
		throw new NotImplementedYetException();
	}
}
