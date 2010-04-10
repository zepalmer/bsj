package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.annotation.Generated;
/**
 * A diagnostic representing a single static import which used an unqualified name.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface UnqualifiedSingleStaticImportNameDiagnostic extends BsjParserDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.invalidSingleStaticImportName";
    
    /**
     * Retrieves the name which was provided.
     * @return The name which was provided.
     */
    public String getName();
    
}
