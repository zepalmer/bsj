package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

/**
 * A diagnostic which represents some problem in the definition of a meta-annotation type's getter or
 * setter methods.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InvalidMetaAnnotationMethodDiagnostic extends InvalidMetaAnnotationDiagnostic
{
    /**
     * Retrieves the type of method with which there is a problem.
     * @return The type of method with which there is a problem.
     */
    public MetaAnnotationMethodType getMethodType();
    
    /**
     * Retrieves the name of the method with which there is a problem.
     * @return The name of the method with which there is a problem.
     */
    public String getMethodName();
    
}
