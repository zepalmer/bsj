package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;
/**
 * A diagnostic indicating that a meta-annotation refers to a class which does not implement the
 * {@link BsjMetaAnnotation} interface.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaAnnotationClassTypeMismatchDiagnostic extends InvalidMetaAnnotationDefinitionDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaAnnotation.typeMismatch";
    
    /**
     * Retrieves a string naming the class that was used.
     * @return A string naming the class that was used.
     */
    public String getClassName();
    
}
