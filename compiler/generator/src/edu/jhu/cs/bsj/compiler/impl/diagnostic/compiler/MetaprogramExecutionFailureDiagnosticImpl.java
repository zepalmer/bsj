package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramExecutionFailureDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic indicating that the execution of a metaprogram failed due to the metaprogram itself
 * raising a {@link MetaprogramExecutionFailureException}.  The exception is provided to allow the
 * creation of its stack trace.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramExecutionFailureDiagnosticImpl extends MetaprogramErrorDiagnosticImpl implements MetaprogramExecutionFailureDiagnostic
{
    /** The exception which was raised to indicate failure. */
    private MetaprogramExecutionFailureException exception;
    
    public MetaprogramExecutionFailureDiagnosticImpl(
            BsjSourceLocation source,
            MetaprogramExecutionFailureException exception)
    {
        super(source, MetaprogramExecutionFailureDiagnostic.CODE, Kind.ERROR);
        this.exception = exception;
    }
    
    /**
     * {@inheritDoc}
     */
    public MetaprogramExecutionFailureException getException()
    {
        return this.exception;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.exception);
        args.getSecond().put("exception", args.getFirst().size());
        args.getFirst().add(DiagnosticMessageUtilities.getExceptionString(exception,locale));
        args.getSecond().put("stackTrace", args.getFirst().size());
        return args;
    }
    
}
