package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.parser.ExtraneousTokenDiagnostic;


/**
 * A diagnostic representing the presence of an extraneous token.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ExtraneousTokenDiagnosticImpl<T extends javax.tools.JavaFileObject> extends BsjParserDiagnosticImpl<T> implements ExtraneousTokenDiagnostic<T>
{
    /** The type of the extraneous token. */
    private String extraneousType;
    
    /** The text of the extraneous token. */
    private String extraneousToken;
    
    public ExtraneousTokenDiagnosticImpl(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String extraneousType,
            String extraneousToken)
    {
        super(lineNumber, columnNumber, source, ExtraneousTokenDiagnostic.CODE, Kind.ERROR, ruleName);
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
