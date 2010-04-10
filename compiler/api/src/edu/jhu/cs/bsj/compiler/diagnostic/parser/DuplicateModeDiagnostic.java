package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.annotation.Generated;
/**
 * A diagnostic representing a duplicated metaprogram mode.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface DuplicateModeDiagnostic extends BsjParserDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.duplicateMode";
    
    /**
     * Retrieves the mode which was duplicated.
     * @return The mode which was duplicated.
     */
    public String getMode();
    
}
