package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramErrorException;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramDetectedErrorDiagnostic;


/**
 * A diagnostic indicating that some kind of exception was raised by the compiler from within a
 * metaprogram's library call which represents an error in a BSJ metaprogram.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MetaprogramDetectedErrorDiagnosticImpl<T extends MetaprogramErrorException> extends MetaprogramErrorDiagnosticImpl implements MetaprogramDetectedErrorDiagnostic<T>
{
    /** The exception which was caught by the compiler. */
    private T exception;
    
    public MetaprogramDetectedErrorDiagnosticImpl(
            BsjSourceLocation source,
            String code,
            javax.tools.Diagnostic.Kind kind,
            T exception)
    {
        super(source, code, kind);
        this.exception = exception;
    }
    
    /**
     * {@inheritDoc}
     */
    public T getException()
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
