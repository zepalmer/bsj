package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.ExtraneousTokenDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic representing the presence of an extraneous token.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ExtraneousTokenDiagnosticImpl extends BsjParserDiagnosticImpl implements ExtraneousTokenDiagnostic
{
    /** The type of the extraneous token. */
    private String extraneousType;
    
    /** The text of the extraneous token. */
    private String extraneousToken;
    
    public ExtraneousTokenDiagnosticImpl(
            BsjSourceLocation source,
            String ruleName,
            String extraneousType,
            String extraneousToken)
    {
        super(source, ExtraneousTokenDiagnostic.CODE, Kind.ERROR, ruleName);
        this.extraneousType = extraneousType;
        this.extraneousToken = extraneousToken;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getExtraneousType()
    {
        return this.extraneousType;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getExtraneousToken()
    {
        return this.extraneousToken;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.extraneousType);
        args.getSecond().put("extraneousType", args.getFirst().size());
        args.getFirst().add(this.extraneousToken);
        args.getSecond().put("extraneousToken", args.getFirst().size());
        return args;
    }
    
}
