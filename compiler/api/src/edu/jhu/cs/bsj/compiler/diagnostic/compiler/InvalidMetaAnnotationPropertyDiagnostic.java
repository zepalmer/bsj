package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;
/**
 * A diagnostic which represents some problem with a meta-annotation's properties.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InvalidMetaAnnotationPropertyDiagnostic extends InvalidMetaAnnotationDefinitionDiagnostic
{
    /**
     * Retrieves the name of the property with which there is a problem.
     * @return The name of the property with which there is a problem.
     */
    public String getPropertyName();
    
}
