package edu.jhu.cs.bsj.compiler.error.parser;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * This exception indicates that a modifier appeared twice.  Modifiers should only appear at most once in each place
 * they are permitted.
 * @author Zachary Palmer
 */
public class DuplicateModifierError extends BsjParserError
{
	private static final long serialVersionUID = 1L;
	
	/** The string indicating the modifier which was used. */
	private String modifierName;

	public DuplicateModifierError(BsjSourceLocation location, String modifierName)
	{
		super(location);
		this.modifierName = modifierName;
	}
	
	public String getModifierName()
	{
		return modifierName;
	}
}
