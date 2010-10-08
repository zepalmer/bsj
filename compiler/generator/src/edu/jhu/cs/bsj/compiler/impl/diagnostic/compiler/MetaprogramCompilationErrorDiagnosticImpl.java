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
import javax.tools.Diagnostic;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramCompilationErrorDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


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
