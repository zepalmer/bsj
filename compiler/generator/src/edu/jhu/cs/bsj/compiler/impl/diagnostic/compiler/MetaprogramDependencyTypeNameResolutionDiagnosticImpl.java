package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramDependencyTypeNameResolutionDiagnostic;


/**
 * A diagnostic indicating that a metaprogram's dependency list contains a target whose type name could
 * not be resolved.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramDependencyTypeNameResolutionDiagnosticImpl extends BsjCompilerDiagnosticImpl implements MetaprogramDependencyTypeNameResolutionDiagnostic
{
    /** The name of the type which could not be resolved. */
    private String typeName;
    
    public MetaprogramDependencyTypeNameResolutionDiagnosticImpl(
            BsjSourceLocation source,
            String typeName)
    {
        super(source, MetaprogramDependencyTypeNameResolutionDiagnostic.CODE, Kind.ERROR);
        this.typeName = typeName;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getTypeName()
    {
        return this.typeName;
    }
    
    @Override
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        args.add(this.typeName);
        return args;
    }
    
}
