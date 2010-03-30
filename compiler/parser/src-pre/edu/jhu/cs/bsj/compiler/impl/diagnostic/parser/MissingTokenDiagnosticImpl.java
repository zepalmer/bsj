package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.parser.MissingTokenDiagnostic;


/**
 * A diagnostic representing a missing token.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MissingTokenDiagnosticImpl<T extends javax.tools.JavaFileObject> extends BsjParserDiagnosticImpl<T> implements MissingTokenDiagnostic<T>
{
    /** The type of the missing token. */
    private String tokenType;
    
    public MissingTokenDiagnosticImpl(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String tokenType)
    {
        super(lineNumber, columnNumber, source, MissingTokenDiagnostic.CODE, Kind.ERROR, ruleName);
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
