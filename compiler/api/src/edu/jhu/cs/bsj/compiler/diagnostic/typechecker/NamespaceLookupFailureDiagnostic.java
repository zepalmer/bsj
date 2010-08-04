package edu.jhu.cs.bsj.compiler.diagnostic.typechecker;

import javax.annotation.Generated;
/**
 * Indicates that a namespace lookup failed during BSJ type checking.  This means that some type name
 * could not be resolved to a unique type.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface NamespaceLookupFailureDiagnostic extends BsjTypeCheckerDiagnostic
{
    /**
     * Retrieves the name of the type which could not be resolved or was ambiguous.
     * @return The name of the type which could not be resolved or was ambiguous.
     */
    public String getName();
    
}
