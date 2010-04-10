package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
/**
 * A diagnostic indicating that an injection conflict has occurred.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InjectionConfictDiagnostic extends BsjCompilerDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.conflict.injection";
    
    /**
     * Retrieves the location of the metaprograms that injected the conflicting metaprogram.
     * @return The location of the metaprograms that injected the conflicting metaprogram.
     */
    public Set<BsjSourceLocation> getInjectingMetaprogramLocations();
    
    /**
     * Retrieves the location of the metaprogram that was injected.
     * @return The location of the metaprogram that was injected.
     */
    public BsjSourceLocation getInjectedMetaprogramLocation();
    
    /**
     * Retrieves the location of the metaprogram that should depend on one of the injecting metaprograms.
     * @return The location of the metaprogram that should depend on one of the injecting metaprograms.
     */
    public BsjSourceLocation getDependentMetaprogramLocation();
    
    /**
     * Retrieves the fully-qualified name of the metaprogram target on which the dependent metaprogram depends and in which the injected metaprogram participates.
     * @return The fully-qualified name of the metaprogram target on which the dependent metaprogram depends and in which the injected metaprogram participates.
     */
    public String getInjectionTarget();
    
}
