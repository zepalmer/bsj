package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InjectionConfictDiagnostic;


/**
 * A diagnostic indicating that an injection conflict has occurred.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InjectionConfictDiagnosticImpl extends BsjCompilerDiagnosticImpl implements InjectionConfictDiagnostic
{
    /** The location of the metaprogram that injected the conflicting metaprogram. */
    private BsjSourceLocation injectingMetaprogramLocation;
    
    /** The location of the metaprogram that should depend on the injecting metaprogram. */
    private BsjSourceLocation dependentMetaprogramLocation;
    
    /** The fully-qualified name of the metaprogram target on which the dependent metaprogram depends and in which the injected metaprogram participates. */
    private String injectionTarget;
    
    public InjectionConfictDiagnosticImpl(
            BsjSourceLocation source,
            BsjSourceLocation injectingMetaprogramLocation,
            BsjSourceLocation dependentMetaprogramLocation,
            String injectionTarget)
    {
        super(source, InjectionConfictDiagnostic.CODE, Kind.ERROR);
        this.injectingMetaprogramLocation = injectingMetaprogramLocation;
        this.dependentMetaprogramLocation = dependentMetaprogramLocation;
        this.injectionTarget = injectionTarget;
    }
    
    /**
     * {@inheritDoc}
     */
    public BsjSourceLocation getInjectingMetaprogramLocation()
    {
        return this.injectingMetaprogramLocation;
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
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.injectingMetaprogramLocation);
        args.add(this.dependentMetaprogramLocation);
        args.add(this.injectionTarget);
        return args;
    }
}
