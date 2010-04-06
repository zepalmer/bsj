package edu.jhu.cs.bsj.compiler.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramDetectedErrorDiagnostic;

/**
 * An exception indicating that the BSJ compiler detected an error in a metaprogram through a
 * library call.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MetaprogramDetectedErrorException extends MetaprogramErrorException
{
    private static final long serialVersionUID = 1L;
    
    public MetaprogramDetectedErrorException()
    {
        super();
    }
    
    /**
     * Creates a {@link BsjDiagnostic} corresponding to this exception type.
     * @param location The source location to report as the cause for the diagnostic.
     * @return A suitable diagnostic.
     */
    public abstract MetaprogramDetectedErrorDiagnostic<?> getDiagnostic(BsjSourceLocation location);
}
