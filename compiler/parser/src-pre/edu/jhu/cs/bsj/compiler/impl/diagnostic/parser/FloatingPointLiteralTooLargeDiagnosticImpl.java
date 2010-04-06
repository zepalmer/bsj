package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.FloatingPointLiteralTooLargeDiagnostic;


/**
 * A diagnostic indicating that a floating point literal was too large to fit into its type.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class FloatingPointLiteralTooLargeDiagnosticImpl extends InvalidFloatingPointLiteralDiagnosticImpl implements FloatingPointLiteralTooLargeDiagnostic
{
    public FloatingPointLiteralTooLargeDiagnosticImpl(
            BsjSourceLocation source,
            String ruleName,
            String literalText)
    {
        super(source, FloatingPointLiteralTooLargeDiagnostic.CODE, Kind.ERROR, ruleName, literalText);
    }
    
    @Override
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        return args;
    }
    
}
