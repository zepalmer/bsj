package edu.jhu.cs.bsj.compiler.exception.parser;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.exception.BsjCompilerException;

/**
 * This compiler error subclass is extended by those exceptions which relate to some form of parse failure.
 * @author Zachary Palmer
 */
public abstract class BsjParserException extends BsjCompilerException
{
	private static final long serialVersionUID = 1L;
	
	/** The location of this error. */
	private BsjSourceLocation location;

	public BsjParserException(BsjSourceLocation location)
	{
		super();
		this.location = location;
	}

	/**
	 * Retrieves the location at which this error occurred.
	 * @return The location at which the error occurred.
	 */
	public BsjSourceLocation getLocation()
	{
		return location;
	}
}
