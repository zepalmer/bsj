package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.annotation.Generated;

/**
 * A diagnostic representing the presence of an extraneous token.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ExtraneousTokenDiagnostic extends BsjParserDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.extraneousToken";
    
    /**
     * Retrieves the type of the extraneous token.
     * @return The type of the extraneous token.
     */
    public String getExtraneousType();
    
    /**
     * Retrieves the text of the extraneous token.
     * @return The text of the extraneous token.
     */
    public String getExtraneousToken();
    
}
