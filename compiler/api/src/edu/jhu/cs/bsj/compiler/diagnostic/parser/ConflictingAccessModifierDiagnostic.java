package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.annotation.Generated;

/**
 * A diagnostic which represents a conflicting access modifier.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ConflictingAccessModifierDiagnostic extends BsjParserDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.conflictingAccessModifier";
    
    /**
     * Retrieves the first modifier which conflicts.
     * @return The first modifier which conflicts.
     */
    public String getFirstModifier();
    
    /**
     * Retrieves the second modifier which conflicts.
     * @return The second modifier which conflicts.
     */
    public String getSecondModifier();
    
}
