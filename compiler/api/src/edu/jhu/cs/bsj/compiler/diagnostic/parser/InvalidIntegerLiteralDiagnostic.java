package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.annotation.Generated;
/**
 * A diagnostic representing an invalid floating point literal.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InvalidIntegerLiteralDiagnostic extends BsjParserDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.invalidIntegerLiteral";
    
    /**
     * Retrieves the text of the invalid literal.
     * @return The text of the invalid literal.
     */
    public String getLiteralText();
    
}
