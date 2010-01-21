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

	public InvalidIntegerLiteralException(String rule, BsjSourceLocation location, String literalText)
	{
		super(rule, location);
		this.literalText = literalText;
	}

	public String getLiteralText()
	{
		return literalText;
	}
}
