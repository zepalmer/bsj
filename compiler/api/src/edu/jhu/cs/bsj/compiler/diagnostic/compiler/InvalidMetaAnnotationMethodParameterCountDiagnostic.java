package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

/**
 * A diagnostic indicating that the number of parameters to a meta-annotation getter or setter method
 * is incorrect.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InvalidMetaAnnotationMethodParameterCountDiagnostic extends InvalidMetaAnnotationMethodDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaAnnotation.method.parameterCount";
    
    /**
     * Retrieves the number of parameters expected.
     * @return The number of parameters expected.
     */
    public int getExpectedCount();
    
    /**
     * Retrieves the number of parameters observed.
     * @return The number of parameters observed.
     */
    public int getObservedCount();
    
}
