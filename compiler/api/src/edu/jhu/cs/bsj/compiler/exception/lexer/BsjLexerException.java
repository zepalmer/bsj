package edu.jhu.cs.bsj.compiler.exception.lexer;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.exception.BsjCompilerException;

/**
 * This type of error is produced when the lexer is incapable of reading the source file.
 * @author Zachary Palmer
 */
public class BsjLexerException extends BsjCompilerException
{
	private static final long serialVersionUID = 1L;
	
	/** The character at which the error occurred. */
	private int character;
	
	/**
	 * Creates a general lexer exception.
	 * @param location The location at which the error occurred.
	 * @param character The character at which the error occurred
	 */
	public BsjLexerException(BsjSourceLocation location, int character)
	{
		super(location);
		this.character  = character;
	}
	
	/**
	 * Creates a general lexer exception.
	 * @param location The location at which the error occurred.
	 * @param cause The cause of this exception.
	 * @param character The character at which the error occurred
	 */
	public BsjLexerException(BsjSourceLocation location, Throwable cause, int character)
	{
		super(location, cause);
		this.character  = character;
	}

	/**
	 * Retrieves the character at which the error occurred.
	 * @return The error character.  <code>-1</code> is used to denote end of stream.
	 */
	public int getCharacter()
	{
		return character;
	}
}
