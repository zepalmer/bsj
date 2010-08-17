package edu.jhu.cs.bsj.compiler.impl.utils;

/**
 * This exception is used as a stop-gap to clearly identify when runtime code has reached a part of the BSJ compiler
 * which has not yet been implemented.
 * @author Zachary Palmer
 */
public class NotImplementedYetException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public NotImplementedYetException()
	{
		super();
	}

	public NotImplementedYetException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public NotImplementedYetException(String message)
	{
		super(message);
	}

	public NotImplementedYetException(Throwable cause)
	{
		super(cause);
	}
}
