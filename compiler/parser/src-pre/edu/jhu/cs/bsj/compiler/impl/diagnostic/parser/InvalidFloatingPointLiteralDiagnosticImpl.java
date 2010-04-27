package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.InvalidFloatingPointLiteralDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


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
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.literalText);
        args.getSecond().put("literalText", args.getFirst().size());
        return args;
    }
    
}
