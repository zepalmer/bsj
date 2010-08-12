package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.SymbolType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeLikeElement;

/**
 * The type of namespace map used in the BSJ typechecker which stores the mappings for the type namespace.
 * @author Zachary Palmer
 */
public class TypeNamespaceMap extends NamespaceMap<BsjTypeLikeElement>
{
	public TypeNamespaceMap(TypeNamespaceMap deferenceMap, DiagnosticListener<BsjSourceLocation> diagnosticListener,
			boolean eager, boolean prohibitsOverlap)
	{
		super(SymbolType.TYPE, deferenceMap, diagnosticListener, eager, prohibitsOverlap);
	}
}
