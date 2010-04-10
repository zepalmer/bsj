package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;
import javax.tools.Diagnostic;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
/**
 * A diagnostic indicating that a subcompilation of a metaprogram failed.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramCompilationErrorDiagnostic<T extends BsjSourceLocation> extends BsjCompilerDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.subcompilation.failure";
    
    /**
     * Retrieves the underlying BSJ compiler diagnostic.
     * @return The underlying BSJ compiler diagnostic.
     */
    public Diagnostic<T> getDiagnostic();
    
}
