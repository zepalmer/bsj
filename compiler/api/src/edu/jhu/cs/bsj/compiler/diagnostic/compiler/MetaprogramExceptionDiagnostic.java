package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

/**
 * This diagnostic indicates that the body of a metaprogram terminated by raising an exception.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramExceptionDiagnostic extends MetaprogramErrorDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.failure.exception";
    
    /**
     * Retrieves the exception which was raised by the metaprogram.
     * @return The exception which was raised by the metaprogram.
     */
    public Exception getException();
    
}
