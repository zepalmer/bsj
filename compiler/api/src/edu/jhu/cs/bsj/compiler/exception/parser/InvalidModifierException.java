package edu.jhu.cs.bsj.compiler.exception.parser;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * This exception indicates that a modifier is present in a place where it is not allowed (such as "volatile" on a class
 * declaration).
 * @author Zachary Palmer
 */
public class InvalidModifierException extends BsjParserException
{
	private static final long serialVersionUID = 1L;
	
	/** The string indicating the modifier which was used. */
	private String modifierName;

	public InvalidModifierException(String rule, BsjSourceLocation location, String modifierName)
	{
		super(rule, location);
		this.modifierName = modifierName;
	}
	
	public String getModifierName()
	{
		return modifierName;
	}
}
