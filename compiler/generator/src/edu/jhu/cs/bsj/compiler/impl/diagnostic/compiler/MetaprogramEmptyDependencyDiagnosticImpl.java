package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramEmptyDependencyDiagnostic;


/**
 * A diagnostic indicating that a metaprogram's dependency list contains a non-weak target in which
 * no metaprograms participate.  This usually indicates that the name of the target contains a
 * typographical error.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramEmptyDependencyDiagnosticImpl extends BsjCompilerDiagnosticImpl implements MetaprogramEmptyDependencyDiagnostic
{
    /** The name of the target on which the metaprogram depends. */
    private String name;
    
    public MetaprogramEmptyDependencyDiagnosticImpl(
            BsjSourceLocation source,
            String name)
    {
        super(source, MetaprogramEmptyDependencyDiagnostic.CODE, Kind.ERROR);
        this.name = name;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getName()
    {
        return this.name;
    }
    
    @Override
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        args.add(this.name);
        return args;
    }
    
}