package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.parser.UnexpectedTokenDiagnostic;


/**
 * A diagnostic representing the presence of one token where another was expected.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class UnexpectedTokenDiagnosticImpl<T extends javax.tools.JavaFileObject> extends BsjParserDiagnosticImpl<T> implements UnexpectedTokenDiagnostic<T>
{
    /** The type of the token which was found. */
    private String tokenType;
    
    /** The text of the token which was found. */
    private String tokenText;
    
    /** The type of the expected token. */
    private String expectedType;
    
    public UnexpectedTokenDiagnosticImpl(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String tokenType,
            String tokenText,
            String expectedType)
    {
        super(lineNumber, columnNumber, source, UnexpectedTokenDiagnostic.CODE, Kind.ERROR, ruleName);
        this.tokenType = tokenType;
        this.tokenText = tokenText;
        this.expectedType = expectedType;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getTokenType()
    {
        return this.tokenType;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getTokenText()
    {
        return this.tokenText;
    }
    
    /**
     * {@inheritDoc}
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
