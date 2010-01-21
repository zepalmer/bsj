package edu.jhu.cs.bsj.compiler.exception.parser;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * This type of parsing exception indicates that an unwanted token has appeared in the token stream. This indicates that
 * it is likely that removing the token would solve the problem (such as in the code <tt>foo());</tt>, where the second
 * closing parenthesis is extraneous and should be discarded).
 * 
 * @author Zachary Palmer
 */
public class ExtraneousTokenException extends BsjParserException
{
	private static final long serialVersionUID = 1L;

	/** The name of the extraneous token's type. */
	private String tokenType;
	/** The text of the extraneous token. */
	private String tokenText;

	public ExtraneousTokenException(String rule, BsjSourceLocation location, String tokenType, String tokenText)
	{
		super(rule, location);
		this.tokenType = tokenType;
		this.tokenText = tokenText;
	}

	public ExtraneousTokenException(String rule, BsjSourceLocation location, Throwable cause, String tokenType,
			String tokenText)
	{
		super(rule, location, cause);
		this.tokenType = tokenType;
		this.tokenText = tokenText;
	}

	public String getTokenType()
	{
		return tokenType;
	}

	public String getTokenText()
	{
		return tokenText;
	}
}
