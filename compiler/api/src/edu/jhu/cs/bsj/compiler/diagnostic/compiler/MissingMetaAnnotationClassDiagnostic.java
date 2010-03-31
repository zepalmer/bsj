package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

/**
 * A diagnostic indicating that a meta-annotation refers to a class which does not exist on the
 * metaprogram classpath at runtime.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MissingMetaAnnotationClassDiagnostic extends UninstantiableMetaAnnotationDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaAnnotation.missingClass";
    
    /**
     * Retrieves a string naming the class that was not found.
     * @return A string naming the class that was not found.
     */
    public String getClassName();
    
}
