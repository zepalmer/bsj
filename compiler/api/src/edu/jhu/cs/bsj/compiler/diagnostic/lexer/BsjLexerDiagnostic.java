package edu.jhu.cs.bsj.compiler.diagnostic.lexer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.JavaFileObject;

import edu.jhu.cs.bsj.compiler.diagnostic.AbstractBsjDiagnostic;

/**
 * This type of diagnostic represents those diagnostics which are produced by the BSJ lexer.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of the source of this diagnostic.
 */
public abstract class BsjLexerDiagnostic<T extends JavaFileObject> extends AbstractBsjDiagnostic<T>
{
	/**
	 * The character which caused this diagnostic.
	 */
	private int character;
	
	/**
	 * @param rule The rule which produced this diagnostic.
	 * @param character The character which produced this diagnostic (or <code>-1</code> for EOF).
	 * @see AbstractBsjDiagnostic#AbstractBsjDiagnostic(long, long, JavaFileObject, String, javax.tools.Diagnostic.Kind)
	 */
	public BsjLexerDiagnostic(long lineNumber, long columnNumber, T source, String code, Kind kind, int character)
	{
		super(lineNumber, columnNumber, source, code, kind);
		this.character = character;
	}

	/**
	 * Retrieves the character which caused this diagnostic.
	 * @return The character which caused this diagnostic (or <code>-1</code> for EOF).
	 */
	public int getCharacter()
	{
		return character;
	}

	@Override
	protected List<Object> getMessageArgs()
	{
		return new ArrayList<Object>(Arrays.asList(character));
	}
}
