package edu.jhu.cs.bsj.compiler.exception;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * A base class for BSJ compilation errors.
 * @author Zachary Palmer
 */
public abstract class BsjCompilerException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	/** The location of this error. */
	private BsjSourceLocation location;
	
	public BsjCompilerException(BsjSourceLocation location)
	{
		super();
		this.location = location;
	}
	
	public BsjCompilerException(BsjSourceLocation location, Throwable cause)
	{
		super(cause);
		this.location = location;
	}

	/**
	 * Retrieves the location at which this error occurred.
	 * @return The location at which the error occurred or <code>null</code> if no location information is available.
	 */
	public BsjSourceLocation getLocation()
	{
		return location;
	}

	/**
	 * This overridden message generator produces a human-readable debug message describing this parse exception.
	 */
	@Override
	public String getMessage()
	{
		return "@ " + this.getLocation();
	}
}
