package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;
/**
 * A diagnostic indicating that the name of a meta-annotation getter or setter method is invalid.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InvalidMetaAnnotationMethodNameDiagnostic extends InvalidMetaAnnotationMethodDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaAnnotation.method.name";
    
    /**
     * Retrieves the type of error that occurred.
     * @return The type of error that occurred.
     */
    public MetaAnnotationMethodNameErrorType getMethodNameError();
    
}
