package edu.jhu.cs.bsj.compiler.exception.parser;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * This type of parsing exception indicates that a token is missing in the token stream.  This indicates that it is
 * likely that inserting the missing token would solve the problem (such as in the code <tt>(foo();</tt>, where the
 * second closing parenthesis has been omitted).
 * @author Zachary Palmer
 */
public class MissingTokenException extends BsjParserException
{
	private static final long serialVersionUID = 1L;
	
	/** The name of the missing token's type. */
	private String tokenType;
	
	public MissingTokenException(BsjSourceLocation location, String tokenType)
	{
		super(location);
		this.tokenType = tokenType;
	}
	
	public MissingTokenException(BsjSourceLocation location, Throwable cause, String tokenType)
	{
		super(location, cause);
		this.tokenType = tokenType;
	}

	public String getTokenType()
	{
		return tokenType;
	}
}
