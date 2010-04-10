package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.annotation.Generated;
/**
 * A diagnostic indicating that a floating point literal was too small to fit into its type.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface FloatingPointLiteralTooSmallDiagnostic extends InvalidFloatingPointLiteralDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.invalidFloatingPointLiteral.tooSmall";
    
}
