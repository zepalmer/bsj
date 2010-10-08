/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
/**
 * A diagnostic indicating that a Java compilation error occurred.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface JavaCompilationErrorDiagnostic<T extends JavaFileObject> extends BsjCompilerDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.compilation.java.error";
    
    /**
     * Retrieves the underlying Java compiler diagnostic.
     * @return The underlying Java compiler diagnostic.
     */
    public Diagnostic<T> getDiagnostic();
    
}
