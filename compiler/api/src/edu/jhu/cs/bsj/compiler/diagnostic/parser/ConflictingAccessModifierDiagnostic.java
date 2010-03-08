package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

/**
 * A diagnostic which represents a conflicting access modifier.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ConflictingAccessModifierDiagnostic<T extends javax.tools.JavaFileObject> extends BsjParserDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.conflictingAccessModifier";
    
    /** The first modifier which conflicts. */
    private String firstModifier;
    
    /** The second modifier which conflicts. */
    private String secondModifier;
    
    public ConflictingAccessModifierDiagnostic(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String firstModifier,
            String secondModifier)
    {
        super(lineNumber, columnNumber, source, CODE, Kind.ERROR, ruleName);
        this.firstModifier = firstModifier;
        this.secondModifier = secondModifier;
    }
    
    /**
     * Retrieves the first modifier which conflicts.
     * @return The first modifier which conflicts.
     */
    public String getFirstModifier()
    {
        return this.firstModifier;
    }
    
    /**
     * Retrieves the second modifier which conflicts.
     * @return The second modifier which conflicts.
     */
    public String getSecondModifier()
    {
        return this.secondModifier;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.firstModifier);
        args.add(this.secondModifier);
        return args;
    }
}
