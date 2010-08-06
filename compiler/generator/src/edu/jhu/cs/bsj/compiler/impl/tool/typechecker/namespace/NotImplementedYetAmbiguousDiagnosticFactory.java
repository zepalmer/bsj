package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import javax.lang.model.element.Element;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.AmbiguousTypeNameDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.NotImplementedYetException;

/**
 * This factory is intended to be used in cases in which ambiguity handling has not yet been written.  All use of this
 * class should eventually be eliminated.
 * @author Zachary Palmer
 */
public class NotImplementedYetAmbiguousDiagnosticFactory implements AmbiguousDiagnosticFactory<Element>
{
	@Override
	public AmbiguousTypeNameDiagnostic makeDiagnostic(String name, NamespaceEntry<? extends Element> entry,
			BsjSourceLocation sourceLocation)
	{
		throw new NotImplementedYetException();
	}
}
