package edu.jhu.cs.bsj.compiler.error.parser;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.error.BsjCompilerError;

/**
 * This compiler error subclass is extended by those exceptions which relate to some form of parse failure.
 * @author Zachary Palmer
 */
public abstract class BsjParserError extends BsjCompilerError
{
	private static final long serialVersionUID = 1L;
	
	/** The location of this error. */
	private BsjSourceLocation location;

	public BsjParserError(BsjSourceLocation location)
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
