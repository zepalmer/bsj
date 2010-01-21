package edu.jhu.cs.bsj.compiler.exception.parser;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * This exception generally indicates that an incorrect token was found in the token stream.  This can be caused by a
 * number of conditions, including but not limited to extra tokens in the stream or missing tokens (although these
 * may be represented instead as {@link ExtraneousTokenException} or {@link MissingTokenException} if the parser can
 * detect them).
 * @author Zachary Palmer
 */
public class WrongTokenException extends BsjParserException
{
	private static final long serialVersionUID = 1L;
	
	/** The type of the token which was found. */
	private String foundType;
	/** The text of the token which was found. */
	private String foundText;
	/** The type of the token which was expected. */
	private String expectedType;
	
	public WrongTokenException(String rule, BsjSourceLocation location, String foundType, String foundText, String expectedType)
	{
		super(rule, location);
		this.foundType = foundType;
		this.foundText = foundText;
		this.expectedType = expectedType;
	}

	public WrongTokenException(String rule, BsjSourceLocation location, Throwable cause, String foundType, String foundText,
			String expectedType)
	{
		super(rule, location, cause);
		this.foundType = foundType;
		this.foundText = foundText;
		this.expectedType = expectedType;
	}

	public String getFoundType()
	{
		return foundType;
	}

	public String getFoundText()
	{
		return foundText;
	}

	public String getExpectedType()
	{
		return expectedType;
	}
}
