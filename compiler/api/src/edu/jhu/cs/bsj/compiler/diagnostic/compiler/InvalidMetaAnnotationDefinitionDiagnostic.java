package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;

/**
 * A diagnostic which represents some problem in the definition of a meta-annotation.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InvalidMetaAnnotationDefinitionDiagnostic extends BsjCompilerDiagnostic
{
    /**
     * Retrieves the type of the meta-annotation.
     * @return The type of the meta-annotation.
     */
    public Class<? extends BsjMetaAnnotation> getMetaAnnotationClass();
    
}
