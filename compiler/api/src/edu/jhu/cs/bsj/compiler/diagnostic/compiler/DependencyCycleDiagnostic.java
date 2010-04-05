package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * A diagnostic indicating that a cycle was found in the dependency graph.  The list of metaprograms is
 * always one larger than the list of targets and contains the same metaprogram at the beginning and
 * end.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface DependencyCycleDiagnostic extends BsjCompilerDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.dependency.cycle";
    
    /**
     * Retrieves the targets in the cycle.
     * @return The targets in the cycle.
     */
    public List<String> getTargets();
    
    /**
     * Retrieves the locations of the metaprograms in the cycle.
     * @return The locations of the metaprograms in the cycle.
     */
    public List<BsjSourceLocation> getMetaprograms();
    
}
