package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.SymbolType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjExecutableElement;

/**
 * The type of namespace map used in the BSJ typechecker which stores the mappings for the method namespace.
 * @author Zachary Palmer
 */
public class MethodNamespaceMap extends NamespaceMap<BsjExecutableElement>
{
	public MethodNamespaceMap(NamespaceMap<? extends BsjExecutableElement> deferenceMap,
			DiagnosticListener<BsjSourceLocation> diagnosticListener, boolean eager, boolean prohibitsOverlap)
	{
		super(SymbolType.METHOD, deferenceMap, diagnosticListener, eager, prohibitsOverlap);
	}
}
