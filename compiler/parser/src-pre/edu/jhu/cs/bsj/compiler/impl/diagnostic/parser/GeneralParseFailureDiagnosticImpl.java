package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.GeneralParseFailureDiagnostic;


/**
 * A diagnostic representing a general parsing failure starting at a given location.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class GeneralParseFailureDiagnosticImpl extends BsjParserDiagnosticImpl implements GeneralParseFailureDiagnostic
{
    /** The type of the token where the errors started. */
    private String tokenType;
    
    /** The text of the token where the errors started. */
    private String tokenText;
    
    public GeneralParseFailureDiagnosticImpl(
            BsjSourceLocation source,
            String ruleName,
            String tokenType,
            String tokenText)
    {
        super(source, GeneralParseFailureDiagnostic.CODE, Kind.ERROR, ruleName);
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
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        args.add(this.tokenType);
        args.add(this.tokenText);
        return args;
    }
    
}
