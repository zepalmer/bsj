package edu.jhu.cs.bsj.compiler.impl.diagnostic.typechecker;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.NamespaceLookupFailureDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that a namespace lookup failed during BSJ type checking.  This means that some type name
 * could not be resolved to a unique type.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class NamespaceLookupFailureDiagnosticImpl extends BsjTypeCheckerDiagnosticImpl implements NamespaceLookupFailureDiagnostic
{
    /** The name of the type which could not be resolved or was ambiguous. */
    private String name;
    
    public NamespaceLookupFailureDiagnosticImpl(
            BsjSourceLocation source,
            String code,
            javax.tools.Diagnostic.Kind kind,
            String name)
    {
        super(source, code, kind);
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
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.name);
        args.getSecond().put("name", args.getFirst().size());
        return args;
    }
    
}
