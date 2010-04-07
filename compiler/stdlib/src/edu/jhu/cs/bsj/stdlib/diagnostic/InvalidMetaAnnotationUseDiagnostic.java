package edu.jhu.cs.bsj.stdlib.diagnostic;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;

/**
 * A diagnostic indicating that a meta-annotation is used incorrectly.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InvalidMetaAnnotationUseDiagnostic extends BsjUtilDiagnostic
{
    /**
     * Retrieves the class of meta-annotation that was used incorrectly.
     * @return The class of meta-annotation that was used incorrectly.
     */
    public Class<? extends AbstractBsjMetaAnnotationMetaprogram> getMetaAnnotationClass();
    
}
