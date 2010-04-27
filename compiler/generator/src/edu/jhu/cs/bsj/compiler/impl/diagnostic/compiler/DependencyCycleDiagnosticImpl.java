package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.DependencyCycleDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic indicating that a cycle was found in the dependency graph.  The list of metaprograms is
 * always one larger than the list of targets and contains the same metaprogram at the beginning and
 * end.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class DependencyCycleDiagnosticImpl extends BsjCompilerDiagnosticImpl implements DependencyCycleDiagnostic
{
    /** The targets in the cycle. */
    private List<String> targets;
    
    /** The locations of the metaprograms in the cycle. */
    private List<BsjSourceLocation> metaprograms;
    
    public DependencyCycleDiagnosticImpl(
            BsjSourceLocation source,
            List<String> targets,
            List<BsjSourceLocation> metaprograms)
    {
        super(source, DependencyCycleDiagnostic.CODE, Kind.ERROR);
        this.targets = targets;
        this.metaprograms = metaprograms;
    }
    
    /**
     * {@inheritDoc}
     */
    public List<String> getTargets()
    {
        return this.targets;
    }
    
    /**
     * {@inheritDoc}
     */
    public List<BsjSourceLocation> getMetaprograms()
    {
        return this.metaprograms;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.targets);
        args.getSecond().put("targets", args.getFirst().size());
        args.getFirst().add(this.metaprograms);
        args.getSecond().put("metaprograms", args.getFirst().size());
        args.getFirst().add(DiagnosticMessageUtilities.getDependencyString(getMetaprograms(),getTargets()));
        args.getSecond().put("dependencyString", args.getFirst().size());
        return args;
    }
    
}
