package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;
/**
 * A diagnostic indicating that the return type of a property's getter is not assignable from the
 * argument of the property's setter.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaAnnotationPropertyTypeMismatchDiagnostic extends InvalidMetaAnnotationPropertyDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaAnnotation.property.typeMismatch";
    
}
