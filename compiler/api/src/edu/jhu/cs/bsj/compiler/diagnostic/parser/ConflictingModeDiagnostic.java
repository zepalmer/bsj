package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.annotation.Generated;

/**
 * A diagnostic which represents a conflicting metaprogram mode.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ConflictingModeDiagnostic<T extends javax.tools.JavaFileObject> extends BsjParserDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.conflictingMode";
    
    /**
     * Retrieves the first mode which conflicts.
     * @return The first mode which conflicts.
     */
    public String getFirstMode();
    
    /**
     * Retrieves the second mode which conflicts.
     * @return The second mode which conflicts.
     */
    public String getSecondMode();
    
}
