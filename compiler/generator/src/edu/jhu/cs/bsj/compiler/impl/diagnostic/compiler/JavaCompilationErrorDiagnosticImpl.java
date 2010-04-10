package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.JavaCompilationErrorDiagnostic;


/**
 * A diagnostic indicating that a Java compilation error occurred.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class JavaCompilationErrorDiagnosticImpl<T extends JavaFileObject> extends BsjCompilerDiagnosticImpl implements JavaCompilationErrorDiagnostic<T>
{
    /** The underlying Java compiler diagnostic. */
    private Diagnostic<T> diagnostic;
    
    public JavaCompilationErrorDiagnosticImpl(
            BsjSourceLocation source,
            Diagnostic<T> diagnostic)
    {
        super(source, JavaCompilationErrorDiagnostic.CODE, Kind.ERROR);
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
