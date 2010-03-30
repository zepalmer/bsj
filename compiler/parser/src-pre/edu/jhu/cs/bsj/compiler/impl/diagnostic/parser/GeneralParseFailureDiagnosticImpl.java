package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.parser.GeneralParseFailureDiagnostic;


/**
 * A diagnostic representing a general parsing failure starting at a given location.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class GeneralParseFailureDiagnosticImpl<T extends javax.tools.JavaFileObject> extends BsjParserDiagnosticImpl<T> implements GeneralParseFailureDiagnostic<T>
{
    /** The type of the token where the errors started. */
    private String tokenType;
    
    /** The text of the token where the errors started. */
    private String tokenText;
    
    public GeneralParseFailureDiagnosticImpl(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String tokenType,
            String tokenText)
    {
        super(lineNumber, columnNumber, source, GeneralParseFailureDiagnostic.CODE, Kind.ERROR, ruleName);
        this.tokenType = tokenType;
        this.tokenText = tokenText;
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
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.tokenType);
        args.add(this.tokenText);
        return args;
    }
}
