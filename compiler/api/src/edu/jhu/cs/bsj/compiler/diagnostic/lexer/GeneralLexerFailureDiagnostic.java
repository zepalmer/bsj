package edu.jhu.cs.bsj.compiler.diagnostic.lexer;

import java.util.List;

import javax.annotation.Generated;

/**
 * A diagnostic indicating a general lexer failure.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class GeneralLexerFailureDiagnostic<T extends javax.tools.JavaFileObject> extends BsjLexerDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "lexer.error.generalFailure";
    
    public GeneralLexerFailureDiagnostic(
                long lineNumber,
                long columnNumber,
                T source,
                int character)
    {
        super(lineNumber, columnNumber, source, CODE, Kind.ERROR, character);
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        return args;
    }
}
