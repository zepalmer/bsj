package edu.jhu.cs.bsj.compiler.impl.diagnostic.lexer;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.lexer.GeneralLexerFailureDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


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
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        return args;
    }
    
}
