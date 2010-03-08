package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

/**
 * A diagnostic representing an invalid floating point literal.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InvalidIntegerLiteralDiagnostic<T extends javax.tools.JavaFileObject> extends BsjParserDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.invalidIntegerLiteral";
    
    /** The text of the invalid literal. */
    private String literalText;
    
    public InvalidIntegerLiteralDiagnostic(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String literalText)
    {
        super(lineNumber, columnNumber, source, CODE, Kind.ERROR, ruleName);
        this.literalText = literalText;
    }
    
    /**
     * Retrieves the text of the invalid literal.
     * @return The text of the invalid literal.
     */
    public String getLiteralText()
    {
        return this.literalText;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.literalText);
        return args;
    }
}
