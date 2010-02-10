package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.tools.JavaFileObject;

/**
 * Represents a diagnostic which indicates the absence of a required token.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of source for this diagnostic.
 */
public class MissingTokenDiagnostic<T extends JavaFileObject> extends BsjParserDiagnostic<T>
{
	/** The code for this diagnostic. */
	public static final String CODE = "bsj.parser.error.extraneousToken";

	/** The type of the missing token. */
	private String tokenType;

	public MissingTokenDiagnostic(long lineNumber, long columnNumber, T source, String rule,
			String tokenType)
	{
		super(lineNumber, columnNumber, source, CODE, Kind.ERROR, rule);
		this.tokenType = tokenType;
	}

	/**
	 * Retrieves the name of the type of token which was missing.
	 * @return The type of token which was missing.
	 */
	public String getTokenType()
	{
		return tokenType;
	}
}
