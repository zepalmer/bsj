package edu.jhu.cs.bsj.compiler.ast.exception;

/**
 * This is a common supertype of all exceptions thrown by the BSJ compiler because the metaprogram it was executing
 * had failed.
 * @author Zachary Palmer
 */
public class MetaprogramErrorException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public MetaprogramErrorException()
	{
		super();
	}

	public MetaprogramErrorException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public MetaprogramErrorException(String message)
	{
		super(message);
	}

	public MetaprogramErrorException(Throwable cause)
	{
		super(cause);
	}
	
}
