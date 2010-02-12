package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

/**
 * A diagnostic representing the presence of an extraneous token.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ExtraneousTokenDiagnostic<T extends javax.tools.JavaFileObject> extends BsjParserDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.extraneousToken";
    
    /** The type of the extraneous token. */
    private String extraneousType;
    
    /** The text of the extraneous token. */
    private String extraneousToken;
    
    public ExtraneousTokenDiagnostic(
                long lineNumber,
                long columnNumber,
                T source,
                String ruleName,
                String extraneousType,
                String extraneousToken)
    {
        super(lineNumber, columnNumber, source, CODE, Kind.ERROR, ruleName);
        this.extraneousType = extraneousType;
        this.extraneousToken = extraneousToken;
    }
    
    /**
     * Retrieves the type of the extraneous token.
     * @return The type of the extraneous token.
     */
    public String getExtraneousType()
    {
        return this.extraneousType;
    }
    
    /**
     * Retrieves the text of the extraneous token.
     * @return The text of the extraneous token.
     */
    public String getExtraneousToken()
    {
        return this.extraneousToken;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.extraneousType);
        args.add(this.extraneousToken);
        return args;
    }
}
