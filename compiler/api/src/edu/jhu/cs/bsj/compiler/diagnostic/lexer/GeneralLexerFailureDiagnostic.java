package edu.jhu.cs.bsj.compiler.diagnostic.lexer;

import javax.annotation.Generated;

/**
 * A diagnostic indicating a general lexer failure.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface GeneralLexerFailureDiagnostic<T extends javax.tools.JavaFileObject> extends BsjLexerDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "lexer.error.generalFailure";
    
}
