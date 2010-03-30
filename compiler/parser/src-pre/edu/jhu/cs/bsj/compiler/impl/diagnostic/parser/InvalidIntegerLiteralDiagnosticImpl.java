package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.parser.InvalidIntegerLiteralDiagnostic;


/**
 * A diagnostic representing an invalid floating point literal.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InvalidIntegerLiteralDiagnosticImpl<T extends javax.tools.JavaFileObject> extends BsjParserDiagnosticImpl<T> implements InvalidIntegerLiteralDiagnostic<T>
{
    /** The text of the invalid literal. */
    private String literalText;
    
    public InvalidIntegerLiteralDiagnosticImpl(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String literalText)
    {
        super(lineNumber, columnNumber, source, InvalidIntegerLiteralDiagnostic.CODE, Kind.ERROR, ruleName);
        this.literalText = literalText;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getLiteralText()
    {
        return this.literalText;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.literalText);
        return args;
    }
}
