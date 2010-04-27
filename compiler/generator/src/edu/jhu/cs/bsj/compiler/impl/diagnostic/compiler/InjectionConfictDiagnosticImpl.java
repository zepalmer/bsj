package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InjectionConfictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic indicating that an injection conflict has occurred.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InjectionConfictDiagnosticImpl extends BsjCompilerDiagnosticImpl implements InjectionConfictDiagnostic
{
    /** The location of the metaprograms that injected the conflicting metaprogram. */
    private Set<BsjSourceLocation> injectingMetaprogramLocations;
    
    /** The location of the metaprogram that was injected. */
    private BsjSourceLocation injectedMetaprogramLocation;
    
    /** The location of the metaprogram that should depend on one of the injecting metaprograms. */
    private BsjSourceLocation dependentMetaprogramLocation;
    
    /** The fully-qualified name of the metaprogram target on which the dependent metaprogram depends and in which the injected metaprogram participates. */
    private String injectionTarget;
    
    public InjectionConfictDiagnosticImpl(
            BsjSourceLocation source,
            Set<BsjSourceLocation> injectingMetaprogramLocations,
            BsjSourceLocation injectedMetaprogramLocation,
            BsjSourceLocation dependentMetaprogramLocation,
            String injectionTarget)
    {
        super(source, InjectionConfictDiagnostic.CODE, Kind.ERROR);
        this.injectingMetaprogramLocations = injectingMetaprogramLocations;
        this.injectedMetaprogramLocation = injectedMetaprogramLocation;
        this.dependentMetaprogramLocation = dependentMetaprogramLocation;
        this.injectionTarget = injectionTarget;
    }
    
    /**
     * {@inheritDoc}
     */
    public Set<BsjSourceLocation> getInjectingMetaprogramLocations()
    {
        return this.injectingMetaprogramLocations;
    }
    
    /**
     * {@inheritDoc}
     */
    public BsjSourceLocation getInjectedMetaprogramLocation()
    {
        return this.injectedMetaprogramLocation;
    }
    
    /**
     * {@inheritDoc}
     */
    public BsjSourceLocation getDependentMetaprogramLocation()
    {
        return this.dependentMetaprogramLocation;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getInjectionTarget()
    {
        return this.injectionTarget;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.injectingMetaprogramLocations);
        args.getSecond().put("injectingMetaprogramLocations", args.getFirst().size());
        args.getFirst().add(this.injectedMetaprogramLocation);
        args.getSecond().put("injectedMetaprogramLocation", args.getFirst().size());
        args.getFirst().add(this.dependentMetaprogramLocation);
        args.getSecond().put("dependentMetaprogramLocation", args.getFirst().size());
        args.getFirst().add(this.injectionTarget);
        args.getSecond().put("injectionTarget", args.getFirst().size());
        return args;
    }
    
}
