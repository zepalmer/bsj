package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.AmbiguousTypeNameDiagnostic;

/**
 * A factory interface which controls the creation of diagnostics from ambiguous {@link TypeNamespaceEntry} objects.
 * @author Zachary Palmer
 */
public interface AmbiguousDiagnosticFactory
{
	/**
	 * Creates an appropriate diagnostic to report an error.
	 * @param name The name which was ambiguous.
	 * @param entry A {@link TypeNamespaceEntry}.
	 * @param sourceLocation The location at which the error effectively occurred.
	 * @return A diagnostic to report or <code>null</code> if no diagnostic should be reported.
	 */
	public AmbiguousTypeNameDiagnostic makeDiagnostic(String name, TypeNamespaceEntry entry, BsjSourceLocation sourceLocation);
}
