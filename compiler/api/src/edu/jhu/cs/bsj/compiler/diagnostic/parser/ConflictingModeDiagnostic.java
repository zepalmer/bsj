package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

/**
 * A diagnostic which represents a conflicting metaprogram mode.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ConflictingModeDiagnostic<T extends javax.tools.JavaFileObject> extends BsjParserDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.conflictingMode";
    
    /** The first mode which conflicts. */
    private String firstMode;
    
    /** The second mode which conflicts. */
    private String secondMode;
    
    public ConflictingModeDiagnostic(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String firstMode,
            String secondMode)
    {
        super(lineNumber, columnNumber, source, CODE, Kind.ERROR, ruleName);
        this.firstMode = firstMode;
        this.secondMode = secondMode;
    }
    
    /**
     * Retrieves the first mode which conflicts.
     * @return The first mode which conflicts.
     */
    public String getFirstMode()
    {
        return this.firstMode;
    }
    
    /**
     * Retrieves the second mode which conflicts.
     * @return The second mode which conflicts.
     */
    public String getSecondMode()
    {
        return this.secondMode;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.firstMode);
        args.add(this.secondMode);
        return args;
    }
}
