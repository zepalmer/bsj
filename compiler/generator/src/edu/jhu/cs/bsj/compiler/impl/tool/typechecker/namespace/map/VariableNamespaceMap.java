package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map;

import java.util.Collection;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.SymbolType;
import edu.jhu.cs.bsj.compiler.lang.element.BsjVariableElement;

/**
 * The type of namespace map used in the BSJ typechecker which stores the mappings for the variable namespace.
 * @author Zachary Palmer
 */
public class VariableNamespaceMap extends NamespaceMap<String,BsjVariableElement>
{
	public VariableNamespaceMap(Collection<VariableNamespaceMap> deferenceMaps,
			DiagnosticListener<BsjSourceLocation> diagnosticListener, boolean eager, boolean prohibitsOverlap)
	{
		super(SymbolType.VARIABLE, deferenceMaps, diagnosticListener, eager, prohibitsOverlap);
	}
}
