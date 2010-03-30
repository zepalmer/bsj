package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

/**
 * A diagnostic indicating that the specified method was static when it should not be.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface IncorrectlyStaticMetaAnnotationMethodDiagnostic extends InvalidMetaAnnotationMethodDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaAnnotation.method.static";
    
}
