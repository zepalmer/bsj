package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.UnexpectedTokenDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic representing the presence of one token where another was expected.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class UnexpectedTokenDiagnosticImpl extends BsjParserDiagnosticImpl implements UnexpectedTokenDiagnostic
{
    /** The type of the token which was found. */
    private String tokenType;
    
    /** The text of the token which was found. */
    private String tokenText;
    
    /** The type of the expected token. */
    private String expectedType;
    
    public UnexpectedTokenDiagnosticImpl(
            BsjSourceLocation source,
            String ruleName,
            String tokenType,
            String tokenText,
            String expectedType)
    {
        super(source, UnexpectedTokenDiagnostic.CODE, Kind.ERROR, ruleName);
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
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.tokenType);
        args.getSecond().put("tokenType", args.getFirst().size());
        args.getFirst().add(this.tokenText);
        args.getSecond().put("tokenText", args.getFirst().size());
        args.getFirst().add(this.expectedType);
        args.getSecond().put("expectedType", args.getFirst().size());
        return args;
    }
    
}
