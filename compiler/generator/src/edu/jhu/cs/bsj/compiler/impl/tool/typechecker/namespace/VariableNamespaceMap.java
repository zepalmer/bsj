package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.SymbolType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjVariableElement;

/**
 * The type of namespace map used in the BSJ typechecker which stores the mappings for the variable namespace.
 * @author Zachary Palmer
 */
public class VariableNamespaceMap extends NamespaceMap<BsjVariableElement>
{

	public VariableNamespaceMap(NamespaceMap<? extends BsjVariableElement> deferenceMap,
			DiagnosticListener<BsjSourceLocation> diagnosticListener, boolean eager, boolean prohibitsOverlap)
	{
		super(SymbolType.VARIABLE, deferenceMap, diagnosticListener, eager, prohibitsOverlap);
	}

}
