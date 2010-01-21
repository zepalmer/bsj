package edu.jhu.cs.bsj.compiler.exception.parser;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * This exception indicates that two modifiers are declared on the same entity which are mutually exclusive (such as
 * declaring a method both "private" and "public").
 * @author Zachary Palmer
 */
public class ConflictingAccessModifierException extends BsjParserException
{
	private static final long serialVersionUID = 1L;
	
	/** The string indicating the first modifier which was used. */
	private String firstModifierName;
	/** The string indicating the second modifier which was used. */
	private String secondModifierName;
	
	public ConflictingAccessModifierException(String rule, BsjSourceLocation location, String firstModifierName,
			String secondModifierName)
	{
		super(rule, location);
		this.firstModifierName = firstModifierName;
		this.secondModifierName = secondModifierName;
	}

	public String getFirstModifierName()
	{
		return firstModifierName;
	}

	public String getSecondModifierName()
	{
		return secondModifierName;
	}
}
