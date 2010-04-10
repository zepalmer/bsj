package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.annotation.Generated;
/**
 * A diagnostic representing a general parsing failure starting at a given location.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface GeneralParseFailureDiagnostic extends BsjParserDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.generalParseFailure";
    
    /**
     * Retrieves the type of the token where the errors started.
     * @return The type of the token where the errors started.
     */
    public String getTokenType();
    
    /**
     * Retrieves the text of the token where the errors started.
     * @return The text of the token where the errors started.
     */
    public String getTokenText();
    
}
