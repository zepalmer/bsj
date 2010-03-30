package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.ExtraneousTokenDiagnostic;


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
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.extraneousType);
        args.add(this.extraneousToken);
        return args;
    }
}
