/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramErrorException;
/**
 * A diagnostic indicating that some kind of exception was raised by the compiler from within a
 * metaprogram's library call which represents an error in a BSJ metaprogram.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramDetectedErrorDiagnostic<T extends MetaprogramErrorException> extends MetaprogramErrorDiagnostic
{
    /**
     * Retrieves the exception which was caught by the compiler.
     * @return The exception which was caught by the compiler.
     */
    public T getException();
    
}
