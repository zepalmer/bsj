package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

/**
 * A diagnostic representing an invalid metaprogram mode.  Because metaprogram modes are identifiers
 * and not keywords, use of an incorrect mode (one which is parseable as a keyword but has no BSJ
 * meaning) is reported through this type of diagnostic rather than a typical parse failure.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InvalidModeDiagnostic<T extends javax.tools.JavaFileObject> extends BsjParserDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.invalidMode";
    
    /** The invalid mode. */
    private String mode;
    
    public InvalidModeDiagnostic(
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
     * Retrieves the invalid mode.
     * @return The invalid mode.
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
