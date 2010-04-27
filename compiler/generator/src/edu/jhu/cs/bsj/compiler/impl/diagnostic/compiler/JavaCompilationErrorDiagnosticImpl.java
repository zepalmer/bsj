package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.JavaCompilationErrorDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


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
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.diagnostic);
        args.getSecond().put("diagnostic", args.getFirst().size());
        args.getFirst().add(diagnostic.getMessage(locale));
        args.getSecond().put("diagnosticMessage", args.getFirst().size());
        return args;
    }
    
}
