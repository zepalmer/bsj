/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramErrorException;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramDetectedErrorDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


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
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.exception);
        args.getSecond().put("exception", args.getFirst().size());
        return args;
    }
    
}
