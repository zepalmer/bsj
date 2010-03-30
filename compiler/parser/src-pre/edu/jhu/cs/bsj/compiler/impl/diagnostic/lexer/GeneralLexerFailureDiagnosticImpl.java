package edu.jhu.cs.bsj.compiler.impl.diagnostic.lexer;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.lexer.GeneralLexerFailureDiagnostic;


/**
 * A diagnostic indicating a general lexer failure.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class GeneralLexerFailureDiagnosticImpl<T extends javax.tools.JavaFileObject> extends BsjLexerDiagnosticImpl<T> implements GeneralLexerFailureDiagnostic<T>
{
    public GeneralLexerFailureDiagnosticImpl(
            long lineNumber,
            long columnNumber,
            T source,
            int character)
    {
        super(lineNumber, columnNumber, source, GeneralLexerFailureDiagnostic.CODE, Kind.ERROR, character);
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        return args;
    }
}
