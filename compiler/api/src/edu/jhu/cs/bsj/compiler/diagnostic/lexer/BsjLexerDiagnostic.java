package edu.jhu.cs.bsj.compiler.diagnostic.lexer;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;

/**
 * A diagnostic which acts as a supertype for all BSJ lexer diagnostics.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjLexerDiagnostic<T extends javax.tools.JavaFileObject> extends BsjDiagnostic<T>
{
    /**
     * Retrieves the character which caused this diagnostic.
     * @return The character which caused this diagnostic.
     */
    public int getCharacter();
    
}
