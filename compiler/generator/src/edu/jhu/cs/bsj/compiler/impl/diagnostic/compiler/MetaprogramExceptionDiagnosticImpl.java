package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramExceptionDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * This diagnostic indicates that the body of a metaprogram terminated by raising an exception.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramExceptionDiagnosticImpl extends MetaprogramErrorDiagnosticImpl implements MetaprogramExceptionDiagnostic
{
    /** The exception which was raised by the metaprogram. */
    private Exception exception;
    
    public MetaprogramExceptionDiagnosticImpl(
            BsjSourceLocation source,
            Exception exception)
    {
        super(source, MetaprogramExceptionDiagnostic.CODE, Kind.ERROR);
        this.exception = exception;
    }
    
    /**
     * {@inheritDoc}
     */
    public Exception getException()
    {
        return this.exception;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.exception);
        args.getSecond().put("exception", args.getFirst().size());
        args.getFirst().add(DiagnosticMessageUtilities.getIndentedStackTraceString(exception));
        args.getSecond().put("stackTrace", args.getFirst().size());
        return args;
    }
    
}
