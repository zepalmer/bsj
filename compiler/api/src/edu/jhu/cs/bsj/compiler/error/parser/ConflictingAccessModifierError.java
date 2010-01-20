package edu.jhu.cs.bsj.compiler.error.parser;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * This exception indicates that two modifiers are declared on the same entity which are mutually exclusive (such as
 * declaring a method both "private" and "public").
 * @author Zachary Palmer
 */
public class ConflictingAccessModifierError extends BsjParserError
{
	private static final long serialVersionUID = 1L;
	
	/** The string indicating the first modifier which was used. */
	private String firstModifierName;
	/** The string indicating the second modifier which was used. */
	private String secondModifierName;
	
	public ConflictingAccessModifierError(BsjSourceLocation location, String firstModifierName,
			String secondModifierName)
	{
		super(location);
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
