package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;
/**
 * A diagnostic indicating that a metaprogram's dependency list contains a non-weak target in which
 * no metaprograms participate.  This usually indicates that the name of the target contains a
 * typographical error.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramEmptyDependencyDiagnostic extends BsjCompilerDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.dependency.empty";
    
    /**
     * Retrieves the name of the target on which the metaprogram depends.
     * @return The name of the target on which the metaprogram depends.
     */
    public String getName();
    
}
