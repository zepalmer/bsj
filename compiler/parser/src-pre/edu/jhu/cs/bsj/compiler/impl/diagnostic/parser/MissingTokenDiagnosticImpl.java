package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.MissingTokenDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic representing a missing token.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MissingTokenDiagnosticImpl extends BsjParserDiagnosticImpl implements MissingTokenDiagnostic
{
    /** The type of the missing token. */
    private String tokenType;
    
    public MissingTokenDiagnosticImpl(
            BsjSourceLocation source,
            String ruleName,
            String tokenType)
    {
        super(source, MissingTokenDiagnostic.CODE, Kind.ERROR, ruleName);
        this.tokenType = tokenType;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getTokenType()
    {
        return this.tokenType;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.tokenType);
        args.getSecond().put("tokenType", args.getFirst().size());
        return args;
    }
    
}
