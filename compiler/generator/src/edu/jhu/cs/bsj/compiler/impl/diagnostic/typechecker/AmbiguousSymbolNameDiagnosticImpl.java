/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.diagnostic.typechecker;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.AmbiguousSymbolNameDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.SymbolType;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that a symbol name could not be resolved because at least two different symbols of the
 * same symbol type applied.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class AmbiguousSymbolNameDiagnosticImpl extends NamespaceLookupFailureDiagnosticImpl implements AmbiguousSymbolNameDiagnostic
{
    /** The declarations which caused the ambiguity. */
    private Collection<? extends Node> examples;
    
    public AmbiguousSymbolNameDiagnosticImpl(
            BsjSourceLocation source,
            String name,
            SymbolType symbolType,
            Collection<? extends Node> examples)
    {
        super(source, AmbiguousSymbolNameDiagnostic.CODE, Kind.ERROR, name, symbolType);
        this.examples = examples;
    }
    
    /**
     * {@inheritDoc}
     */
    public Collection<? extends Node> getExamples()
    {
        return this.examples;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.examples);
        args.getSecond().put("examples", args.getFirst().size());
        return args;
    }
    
}
