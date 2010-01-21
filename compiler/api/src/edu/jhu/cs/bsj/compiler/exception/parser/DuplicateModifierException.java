package edu.jhu.cs.bsj.compiler.exception.parser;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * This exception indicates that a modifier appeared twice.  Modifiers should only appear at most once in each place
 * they are permitted.
 * @author Zachary Palmer
 */
public class DuplicateModifierException extends BsjParserException
{
	private static final long serialVersionUID = 1L;
	
	/** The string indicating the modifier which was used. */
	private String modifierName;

	public DuplicateModifierException(String rule, BsjSourceLocation location, String modifierName)
	{
		super(rule, location);
		this.modifierName = modifierName;
	}
	
	public String getModifierName()
	{
		return modifierName;
	}
}
