package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

/**
 * A diagnostic representing the presence of one token where another was expected.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class UnexpectedTokenDiagnostic<T extends javax.tools.JavaFileObject> extends BsjParserDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.unexpectedToken";
    
    /** The type of the token which was found. */
    private String tokenType;
    
    /** The text of the token which was found. */
    private String tokenText;
    
    /** The type of the expected token. */
    private String expectedType;
    
    public UnexpectedTokenDiagnostic(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String tokenType,
            String tokenText,
            String expectedType)
    {
        super(lineNumber, columnNumber, source, CODE, Kind.ERROR, ruleName);
        this.tokenType = tokenType;
        this.tokenText = tokenText;
        this.expectedType = expectedType;
    }
    
    /**
     * Retrieves the type of the token which was found.
     * @return The type of the token which was found.
     */
    public String getTokenType()
    {
        return this.tokenType;
    }
    
    /**
     * Retrieves the text of the token which was found.
     * @return The text of the token which was found.
     */
    public String getTokenText()
    {
        return this.tokenText;
    }
    
    /**
     * Retrieves the type of the expected token.
     * @return The type of the expected token.
     */
    public String getExpectedType()
    {
        return this.expectedType;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.tokenType);
        args.add(this.tokenText);
        args.add(this.expectedType);
        return args;
    }
}
