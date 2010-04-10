package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.annotation.Generated;
/**
 * A diagnostic representing the presence of one token where another was expected.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface UnexpectedTokenDiagnostic extends BsjParserDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.unexpectedToken";
    
    /**
     * Retrieves the type of the token which was found.
     * @return The type of the token which was found.
     */
    public String getTokenType();
    
    /**
     * Retrieves the text of the token which was found.
     * @return The text of the token which was found.
     */
    public String getTokenText();
    
    /**
     * Retrieves the type of the expected token.
     * @return The type of the expected token.
     */
    public String getExpectedType();
    
}
