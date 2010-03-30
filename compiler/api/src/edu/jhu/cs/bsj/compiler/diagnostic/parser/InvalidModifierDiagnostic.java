package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.annotation.Generated;

/**
 * A diagnostic representing an invalid modifier (a modifier which appeared in an incorrect context).
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InvalidModifierDiagnostic<T extends javax.tools.JavaFileObject> extends BsjParserDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.invalidModifier";
    
    /**
     * Retrieves the modifier which was used incorrectly.
     * @return The modifier which was used incorrectly.
     */
    public String getModifier();
    
}
