package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

/**
 * A diagnostic indicating that a property's getter or setter is missing.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaAnnotationPropertyMissingMethodDiagnostic extends InvalidMetaAnnotationPropertyDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaAnnotation.property.missingMethod";
    
    /**
     * Retrieves the type of method missing.
     * @return The type of method missing.
     */
    public MetaAnnotationMethodType getMethodType();
    
}
