package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.tools.JavaFileObject;

/**
 * Represents a diagnostic which indicates that the token in a given position was not the one which was expected.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of source for this diagnostic.
 */
public class UnexpectedTokenDiagnostic<T extends JavaFileObject> extends BsjParserDiagnostic<T>
{
	/** The code for this diagnostic. */
	public static final String CODE = "bsj.parser.error.extraneousToken";

	/** The type of the token which was found. */
	private String tokenType;
	/** The text of the token which was found. */
	private String tokenText;
	/** The type of the token which was expected. */
	private String expectedType;

	public UnexpectedTokenDiagnostic(long lineNumber, long columnNumber, T source, String rule,
			String tokenType, String tokenText, String expectedType)
	{
		super(lineNumber, columnNumber, source, CODE, Kind.ERROR, rule);
		this.tokenType = tokenType;
		this.tokenText = tokenText;
		this.expectedType = expectedType;
	}

	/**
	 * Retrieves the name of the type of token which was found.
	 * @return The type of token which was found.
	 */
	public String getTokenType()
	{
		return tokenType;
	}

	/**
	 * Retrieves the text of the token which was found.
	 * @return The text of the token.
	 */
	public String getTokenText()
	{
		return tokenText;
	}

	/**
	 * Retrieves the type of token that was expected.
	 * @return The expected token type.
	 */
	public String getExpectedType()
	{
		return expectedType;
	}
}
