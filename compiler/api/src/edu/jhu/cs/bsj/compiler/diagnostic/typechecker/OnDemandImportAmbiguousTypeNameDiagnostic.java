package edu.jhu.cs.bsj.compiler.diagnostic.typechecker;

import javax.annotation.Generated;
/**
 * Indicates that multiple on-demand imports cause ambiguity over the simple name.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface OnDemandImportAmbiguousTypeNameDiagnostic extends AmbiguousTypeNameDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.typechecker.name.ambiguous.import.onDemand";
    
}
