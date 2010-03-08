package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

/**
 * A diagnostic representing an invalid modifier (a modifier which appeared in an incorrect context).
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InvalidModifierDiagnostic<T extends javax.tools.JavaFileObject> extends BsjParserDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.invalidModifier";
    
    /** The modifier which was used incorrectly. */
    private String modifier;
    
    public InvalidModifierDiagnostic(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String modifier)
    {
        super(lineNumber, columnNumber, source, CODE, Kind.ERROR, ruleName);
        this.modifier = modifier;
    }
    
    /**
     * Retrieves the modifier which was used incorrectly.
     * @return The modifier which was used incorrectly.
     */
    public String getModifier()
    {
        return this.modifier;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.modifier);
        return args;
    }
}
