package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

/**
 * A diagnostic representing a duplicated modifier.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class DuplicateModifierDiagnostic<T extends javax.tools.JavaFileObject> extends BsjParserDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.duplicateModifier";
    
    /** The modifier which was duplicated. */
    private String modifier;
    
    public DuplicateModifierDiagnostic(
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
     * Retrieves the modifier which was duplicated.
     * @return The modifier which was duplicated.
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
