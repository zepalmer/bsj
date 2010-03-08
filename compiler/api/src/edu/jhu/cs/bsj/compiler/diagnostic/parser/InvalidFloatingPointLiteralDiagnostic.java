package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

/**
 * A diagnostic representing an invalid floating point literal.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class InvalidFloatingPointLiteralDiagnostic<T extends javax.tools.JavaFileObject> extends BsjParserDiagnostic<T>
{
    /** The text of the invalid literal. */
    private String literalText;
    
    public InvalidFloatingPointLiteralDiagnostic(
            long lineNumber,
            long columnNumber,
            T source,
            String code,
            javax.tools.Diagnostic.Kind kind,
            String ruleName,
            String literalText)
    {
        super(lineNumber, columnNumber, source, code, kind, ruleName);
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
