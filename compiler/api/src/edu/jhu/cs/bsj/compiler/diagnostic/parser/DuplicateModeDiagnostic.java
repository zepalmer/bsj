package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

/**
 * A diagnostic representing a duplicated metaprogram mode.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class DuplicateModeDiagnostic<T extends javax.tools.JavaFileObject> extends BsjParserDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.duplicateMode";
    
    /** The mode which was duplicated. */
    private String mode;
    
    public DuplicateModeDiagnostic(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String mode)
    {
        super(lineNumber, columnNumber, source, CODE, Kind.ERROR, ruleName);
        this.mode = mode;
    }
    
    /**
     * Retrieves the mode which was duplicated.
     * @return The mode which was duplicated.
     */
    public String getMode()
    {
        return this.mode;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.mode);
        return args;
    }
}
