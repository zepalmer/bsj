package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramExceptionDiagnostic;


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
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        args.add(this.exception);
        return args;
    }
    
}
