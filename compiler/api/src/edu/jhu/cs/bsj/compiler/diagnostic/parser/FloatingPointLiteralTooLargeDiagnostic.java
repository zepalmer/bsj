package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.annotation.Generated;

/**
 * A diagnostic indicating that a floating point literal was too large to fit into its type.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface FloatingPointLiteralTooLargeDiagnostic<T extends javax.tools.JavaFileObject> extends InvalidFloatingPointLiteralDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.invalidFloatingPointLiteral.tooLarge";
    
}
