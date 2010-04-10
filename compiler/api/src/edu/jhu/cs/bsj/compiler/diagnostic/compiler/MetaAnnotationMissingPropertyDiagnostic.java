package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;
/**
 * A diagnostic indicating that a property was used on the invocation of a meta-annotation which did
 * not appear on the definition of the meta-annotation.  This may be because no getter or setter
 * methods exist for that property or because those getter or setter methods are not properly annotated
 * with {@link BsjMetaAnnotationElementGetter} and  {@link BsjMetaAnnotationElementSetter}.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaAnnotationMissingPropertyDiagnostic extends InvalidMetaAnnotationPropertyDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaAnnotation.property.missing";
    
}
