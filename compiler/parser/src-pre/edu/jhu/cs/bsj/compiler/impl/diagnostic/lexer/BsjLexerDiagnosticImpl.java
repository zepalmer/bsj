package edu.jhu.cs.bsj.compiler.impl.diagnostic.lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.lexer.BsjLexerDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.BsjDiagnosticImpl;


/**
 * A diagnostic which acts as a supertype for all BSJ lexer diagnostics.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class BsjLexerDiagnosticImpl extends BsjDiagnosticImpl implements BsjLexerDiagnostic
{
    /** The character which caused this diagnostic. */
    private int character;
    
    public BsjLexerDiagnosticImpl(
            BsjSourceLocation source,
            String code,
            javax.tools.Diagnostic.Kind kind,
            int character)
    {
        super(source, code, kind);
        this.character = character;
    }
    
    /**
     * {@inheritDoc}
     */
    public int getCharacter()
    {
        return this.character;
    }
    
    @Override
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = new ArrayList<Object>();
        args.add(this.character);
        return args;
    }
    
}
