package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.annotation.Generated;

/**
 * A diagnostic representing a duplicated modifier.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface DuplicateModifierDiagnostic extends BsjParserDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.duplicateModifier";
    
    /**
     * Retrieves the modifier which was duplicated.
     * @return The modifier which was duplicated.
     */
    public String getModifier();
    
}
