package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

/**
 * A diagnostic representing a general parsing failure starting at a given location.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class GeneralParseFailureDiagnostic<T extends javax.tools.JavaFileObject> extends BsjParserDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.generalParseFailure";
    
    /** The type of the token where the errors started. */
    private String tokenType;
    
    /** The text of the token where the errors started. */
    private String tokenText;
    
    public GeneralParseFailureDiagnostic(
                long lineNumber,
                long columnNumber,
                T source,
                String ruleName,
                String tokenType,
                String tokenText)
    {
        super(lineNumber, columnNumber, source, CODE, Kind.ERROR, ruleName);
        this.tokenType = tokenType;
        this.tokenText = tokenText;
    }
    
    /**
     * Retrieves the type of the token where the errors started.
     * @return The type of the token where the errors started.
     */
    public String getTokenType()
    {
        return this.tokenType;
    }
    
    /**
     * Retrieves the text of the token where the errors started.
     * @return The text of the token where the errors started.
     */
    public String getTokenText()
    {
        return this.tokenText;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.tokenType);
        args.add(this.tokenText);
        return args;
    }
}
