package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

/**
 * A diagnostic indicating that a floating point literal was too large to fit into its type.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class FloatingPointLiteralTooLargeDiagnostic<T extends javax.tools.JavaFileObject> extends InvalidFloatingPointLiteralDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.invalidFloatingPointLiteral.tooLarge";
    
    public FloatingPointLiteralTooLargeDiagnostic(
                long lineNumber,
                long columnNumber,
                T source,
                String ruleName,
                String literalText)
    {
        super(lineNumber, columnNumber, source, CODE, Kind.ERROR, ruleName, literalText);
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        return args;
    }
}
