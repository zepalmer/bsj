package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;
/**
 * A diagnostic indicating that the return type of a meta-annotation getter or setter method is incorrect.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InvalidMetaAnnotationMethodReturnTypeDiagnostic extends InvalidMetaAnnotationMethodDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaAnnotation.method.returnType";
    
}
