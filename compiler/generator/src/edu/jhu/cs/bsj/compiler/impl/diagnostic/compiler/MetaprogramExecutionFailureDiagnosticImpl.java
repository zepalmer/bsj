package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramExecutionFailureDiagnostic;


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
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        args.add(this.exception);
        args.add(DiagnosticMessageUtilities.getIndentedStackTraceString(exception));
        return args;
    }
    
}
