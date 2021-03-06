/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.stdlib.diagnostic;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaprogramMetaAnnotation;
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
    public Class<? extends AbstractBsjMetaprogramMetaAnnotation> getMetaAnnotationClass();
    
}
