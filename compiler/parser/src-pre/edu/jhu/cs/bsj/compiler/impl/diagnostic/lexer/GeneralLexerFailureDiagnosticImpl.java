package edu.jhu.cs.bsj.compiler.impl.diagnostic.lexer;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.lexer.GeneralLexerFailureDiagnostic;


/**
 * A diagnostic indicating a general lexer failure.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class GeneralLexerFailureDiagnosticImpl extends BsjLexerDiagnosticImpl implements GeneralLexerFailureDiagnostic
{
    public GeneralLexerFailureDiagnosticImpl(
            BsjSourceLocation source,
            int character)
    {
        super(source, GeneralLexerFailureDiagnostic.CODE, Kind.ERROR, character);
    }
    
    @Override
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        return args;
    }
    
}
