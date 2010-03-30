package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.parser.InvalidFloatingPointLiteralDiagnostic;


/**
 * A diagnostic representing an invalid floating point literal.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class InvalidFloatingPointLiteralDiagnosticImpl<T extends javax.tools.JavaFileObject> extends BsjParserDiagnosticImpl<T> implements InvalidFloatingPointLiteralDiagnostic<T>
{
    /** The text of the invalid literal. */
    private String literalText;
    
    public InvalidFloatingPointLiteralDiagnosticImpl(
            long lineNumber,
            long columnNumber,
            T source,
            String code,
            javax.tools.Diagnostic.Kind kind,
            String ruleName,
            String literalText)
    {
        super(lineNumber, columnNumber, source, code, kind, ruleName);
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
