package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.InvalidFloatingPointLiteralDiagnostic;


/**
 * A diagnostic representing an invalid floating point literal.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class InvalidFloatingPointLiteralDiagnosticImpl extends BsjParserDiagnosticImpl implements InvalidFloatingPointLiteralDiagnostic
{
    /** The text of the invalid literal. */
    private String literalText;
    
    public InvalidFloatingPointLiteralDiagnosticImpl(
            BsjSourceLocation source,
            String code,
            javax.tools.Diagnostic.Kind kind,
            String ruleName,
            String literalText)
    {
        super(source, code, kind, ruleName);
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
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        args.add(this.literalText);
        return args;
    }
    
}
