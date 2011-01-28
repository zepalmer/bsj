package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map;

import java.util.Collection;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.SymbolType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.PopulationStrategy;
import edu.jhu.cs.bsj.compiler.impl.utils.function.IdentityFunction;
import edu.jhu.cs.bsj.compiler.lang.element.BsjVariableElement;

/**
 * The type of namespace map used in the BSJ typechecker which stores the mappings for the variable namespace.
 * 
 * @author Zachary Palmer
 */
public class VariableNamespaceMap extends AbstractNamespaceMap<String, BsjVariableElement>
{
    public VariableNamespaceMap(Collection<? extends NamespaceMap<String,BsjVariableElement>> deferenceMaps,
            DiagnosticListener<BsjSourceLocation> diagnosticListener, boolean passiveError, boolean prohibitsOverlap,
            Collection<? extends PopulationStrategy<String, BsjVariableElement>> populationStrategies)
    {
        super(SymbolType.VARIABLE, deferenceMaps, diagnosticListener, passiveError, prohibitsOverlap,
                populationStrategies, IdentityFunction.<String>instance());
    }
}
