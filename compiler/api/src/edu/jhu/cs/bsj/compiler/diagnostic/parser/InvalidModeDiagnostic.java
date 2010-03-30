package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.annotation.Generated;

/**
 * A diagnostic representing an invalid metaprogram mode.  Because metaprogram modes are identifiers
 * and not keywords, use of an incorrect mode (one which is parseable as a keyword but has no BSJ
 * meaning) is reported through this type of diagnostic rather than a typical parse failure.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InvalidModeDiagnostic extends BsjParserDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.invalidMode";
    
    /**
     * Retrieves the invalid mode.
     * @return The invalid mode.
     */
    public String getMode();
    
}
