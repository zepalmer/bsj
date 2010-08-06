package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import javax.lang.model.element.Element;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.AmbiguousTypeNameDiagnostic;

/**
 * A factory interface which controls the creation of diagnostics from ambiguous {@link NamespaceEntry} objects.
 * @author Zachary Palmer
 */
public interface AmbiguousDiagnosticFactory<T extends Element>
{
	/**
	 * Creates an appropriate diagnostic to report an error.  This method may only be called using an entry with at
	 * least two distinct values.
	 * @param name The name which was ambiguous.
	 * @param entry A {@link NamespaceEntry}.
	 * @param sourceLocation The location at which the error effectively occurred.
	 * @return A diagnostic to report or <code>null</code> if no diagnostic should be reported.
	 */
	public AmbiguousTypeNameDiagnostic makeDiagnostic(String name, NamespaceEntry<? extends T> entry, BsjSourceLocation sourceLocation);
}
