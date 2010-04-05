package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.DependencyCycleDiagnostic;


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
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.targets);
        args.add(this.metaprograms);
        args.add(DiagnosticMessageUtilities.getDependencyString(getMetaprograms(),getTargets()));
        return args;
    }
}
