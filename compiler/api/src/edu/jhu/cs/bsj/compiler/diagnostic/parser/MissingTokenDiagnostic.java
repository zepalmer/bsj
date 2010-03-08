package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

/**
 * A diagnostic representing a missing token.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MissingTokenDiagnostic<T extends javax.tools.JavaFileObject> extends BsjParserDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.missingToken";
    
    /** The type of the missing token. */
    private String tokenType;
    
    public MissingTokenDiagnostic(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String tokenType)
    {
        super(lineNumber, columnNumber, source, CODE, Kind.ERROR, ruleName);
        this.tokenType = tokenType;
    }
    
    /**
     * Retrieves the type of the missing token.
     * @return The type of the missing token.
     */
    public String getTokenType()
    {
        return this.tokenType;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.tokenType);
        return args;
    }
}
