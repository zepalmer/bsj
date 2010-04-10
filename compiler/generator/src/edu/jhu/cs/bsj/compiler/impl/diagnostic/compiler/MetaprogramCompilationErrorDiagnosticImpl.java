package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;
import javax.tools.Diagnostic;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramCompilationErrorDiagnostic;


/**
 * A diagnostic indicating that a subcompilation of a metaprogram failed.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramCompilationErrorDiagnosticImpl<T extends BsjSourceLocation> extends BsjCompilerDiagnosticImpl implements MetaprogramCompilationErrorDiagnostic<T>
{
    /** The underlying BSJ compiler diagnostic. */
    private Diagnostic<T> diagnostic;
    
    public MetaprogramCompilationErrorDiagnosticImpl(
            BsjSourceLocation source,
            Diagnostic<T> diagnostic)
    {
        super(source, MetaprogramCompilationErrorDiagnostic.CODE, Kind.ERROR);
        this.diagnostic = diagnostic;
    }
    
    /**
     * {@inheritDoc}
     */
    public Diagnostic<T> getDiagnostic()
    {
        return this.diagnostic;
    }
    
    @Override
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        args.add(this.diagnostic);
        args.add(diagnostic.getMessage(locale));
        return args;
    }
    
}
