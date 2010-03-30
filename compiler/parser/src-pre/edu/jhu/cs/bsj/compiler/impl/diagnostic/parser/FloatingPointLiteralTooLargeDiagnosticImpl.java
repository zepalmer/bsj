package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.parser.FloatingPointLiteralTooLargeDiagnostic;


/**
 * A diagnostic indicating that a floating point literal was too large to fit into its type.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class FloatingPointLiteralTooLargeDiagnosticImpl<T extends javax.tools.JavaFileObject> extends InvalidFloatingPointLiteralDiagnosticImpl<T> implements FloatingPointLiteralTooLargeDiagnostic<T>
{
    public FloatingPointLiteralTooLargeDiagnosticImpl(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String literalText)
    {
        super(lineNumber, columnNumber, source, FloatingPointLiteralTooLargeDiagnostic.CODE, Kind.ERROR, ruleName, literalText);
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        return args;
    }
}
