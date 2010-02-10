package edu.jhu.cs.bsj.compiler.diagnostic.lexer;

import javax.tools.JavaFileObject;

/**
 * Represents a general failure of the lexer.  This diagnostic is generated as a catch-all when no more specific
 * information can be provided.
 * @author Zachary Palmer
 */
public class GeneralLexerFailureDiagnostic<T extends JavaFileObject> extends BsjLexerDiagnostic<T>
{
	/** The code used for this diagnostic. */
	public static final String CODE = "lexer.error.generalFailure";
	
	/**
	 * @see BsjLexerDiagnostic#BsjLexerDiagnostic(long, long, JavaFileObject, String, Kind, int)
	 */
	public GeneralLexerFailureDiagnostic(long lineNumber, long columnNumber, T source,
			int character)
	{
		super(lineNumber, columnNumber, source, CODE, Kind.ERROR, character);
	}
}
