/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
/**
 * A diagnostic indicating that the execution of a metaprogram failed due to the metaprogram itself
 * raising a {@link MetaprogramExecutionFailureException}.  The exception is provided to allow the
 * creation of its stack trace.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramExecutionFailureDiagnostic extends MetaprogramErrorDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.failure.general";
    
    /**
     * Retrieves the exception which was raised to indicate failure.
     * @return The exception which was raised to indicate failure.
     */
    public MetaprogramExecutionFailureException getException();
    
}
