package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.MissingTokenDiagnostic;


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
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.tokenType);
        return args;
    }
}
