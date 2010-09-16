package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.FloatingPointLiteralTooLargeDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


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
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        return args;
    }
    
}
