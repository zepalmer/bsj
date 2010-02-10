package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.tools.JavaFileObject;

/**
 * Represents a diagnostic which indicates the presence of an extraneous token.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of source for this diagnostic.
 */
public class ExtraneousTokenDiagnostic<T extends JavaFileObject> extends BsjParserDiagnostic<T>
{
	/** The code for this diagnostic. */
	public static final String CODE = "bsj.parser.error.extraneousToken";

	/** The type of the extraneous token. */
	private String tokenType;
	/** The text of the extraneous token. */
	private String tokenText;

	public ExtraneousTokenDiagnostic(long lineNumber, long columnNumber, T source, String rule,
			String tokenType, String tokenText)
	{
		super(lineNumber, columnNumber, source, CODE, Kind.ERROR, rule);
		this.tokenType = tokenType;
		this.tokenText = tokenText;
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
	 * @return The text of the extraneous token.
	 */
	public String getTokenText()
	{
		return tokenText;
	}
}
