package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.AmbiguousTypeNameDiagnostic;

/**
 * This factory never produces a diagnostic.  It is used when diagnostic production would be redundant as another
 * mechanism already produces an appropriate diagnostic.
 * @author Zachary Palmer
 */
public class VoidDiagnosticFactory implements AmbiguousDiagnosticFactory
{
	@Override
	public AmbiguousTypeNameDiagnostic makeDiagnostic(String name, TypeNamespaceEntry entry,
			BsjSourceLocation sourceLocation)
	{
		return null;
	}
}
