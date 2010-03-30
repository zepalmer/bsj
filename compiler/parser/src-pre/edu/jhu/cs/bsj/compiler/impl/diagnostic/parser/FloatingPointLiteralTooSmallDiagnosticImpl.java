package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.FloatingPointLiteralTooSmallDiagnostic;


/**
 * A diagnostic indicating that a floating point literal was too small to fit into its type.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class FloatingPointLiteralTooSmallDiagnosticImpl extends InvalidFloatingPointLiteralDiagnosticImpl implements FloatingPointLiteralTooSmallDiagnostic
{
    public FloatingPointLiteralTooSmallDiagnosticImpl(
            BsjSourceLocation source,
            String ruleName,
            String literalText)
    {
        super(source, FloatingPointLiteralTooSmallDiagnostic.CODE, Kind.ERROR, ruleName, literalText);
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        return args;
    }
}
