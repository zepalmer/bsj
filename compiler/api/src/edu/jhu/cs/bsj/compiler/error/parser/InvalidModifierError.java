package edu.jhu.cs.bsj.compiler.error.parser;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * This exception indicates that a modifier is present in a place where it is not allowed (such as "volatile" on a class
 * declaration).
 * @author Zachary Palmer
 */
public class InvalidModifierError extends BsjParserError
{
	private static final long serialVersionUID = 1L;
	
	/** The string indicating the modifier which was used. */
	private String modifierName;

	public InvalidModifierError(BsjSourceLocation location, String modifierName)
	{
		super(location);
		this.modifierName = modifierName;
	}
	
	public String getModifierName()
	{
		return modifierName;
	}
}
