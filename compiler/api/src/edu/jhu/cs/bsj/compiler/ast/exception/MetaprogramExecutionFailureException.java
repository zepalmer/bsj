package edu.jhu.cs.bsj.compiler.ast.exception;

/**
 * This exception is intended to be raised by metaprograms whose execution fails. The raising of this exception
 * terminates compilation. An error diagnostic is logged on the metaprogram's behalf.
 * 
 * @author Zachary Palmer
 */
public class MetaprogramExecutionFailureException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public MetaprogramExecutionFailureException()
	{
		super();
	}

	public MetaprogramExecutionFailureException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public MetaprogramExecutionFailureException(String message)
	{
		super(message);
	}

	public MetaprogramExecutionFailureException(Throwable cause)
	{
		super(cause);
	}
}
