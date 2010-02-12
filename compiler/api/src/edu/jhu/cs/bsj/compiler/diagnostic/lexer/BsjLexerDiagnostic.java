package edu.jhu.cs.bsj.compiler.diagnostic.lexer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.AbstractBsjDiagnostic;

/**
 * A diagnostic which acts as a supertype for all BSJ lexer diagnostics.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class BsjLexerDiagnostic<T extends javax.tools.JavaFileObject> extends AbstractBsjDiagnostic<T>
{
    /** The character which caused this diagnostic. */
    private int character;
    
    public BsjLexerDiagnostic(
                long lineNumber,
                long columnNumber,
                T source,
                String code,
                javax.tools.Diagnostic.Kind kind,
                int character)
    {
        super(lineNumber, columnNumber, source, code, kind);
        this.character = character;
    }
    
    /**
     * Retrieves the character which caused this diagnostic.
     * @return The character which caused this diagnostic.
     */
    public int getCharacter()
    {
        return this.character;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = new ArrayList<Object>();
        args.add(this.character);
        return args;
    }
}
