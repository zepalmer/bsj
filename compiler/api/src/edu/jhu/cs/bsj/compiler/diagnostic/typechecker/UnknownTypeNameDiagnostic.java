package edu.jhu.cs.bsj.compiler.diagnostic.typechecker;

import javax.annotation.Generated;
/**
 * Indicates that a type name could not be resolved because no such type declaration could be found
 * in scope.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface UnknownTypeNameDiagnostic extends NamespaceLookupFailureDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.typechecker.name.unknown";
    
}
