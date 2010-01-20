package edu.jhu.cs.bsj.compiler.exception.parser;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * 
 * @author Zachary Palmer
 */
public class InvalidIntegerLiteralException extends BsjParserException
{
	private static final long serialVersionUID = 1L;
	
	/** The text of the invalid literal. */
	private String literalText;

	public InvalidIntegerLiteralException(BsjSourceLocation location, String literalText)
	{
		super(location);
		this.literalText = literalText;
	}

	public String getLiteralText()
	{
		return literalText;
	}
}
