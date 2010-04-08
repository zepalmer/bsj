package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

/**
 * A diagnostic indicating that a metaprogram's dependency list contains a target whose type name could
 * not be resolved.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramDependencyTypeNameResolutionDiagnostic extends BsjCompilerDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.dependency.resolution.typeName";
    
    /**
     * Retrieves the name of the type which could not be resolved.
     * @return The name of the type which could not be resolved.
     */
    public String getTypeName();
    
}
