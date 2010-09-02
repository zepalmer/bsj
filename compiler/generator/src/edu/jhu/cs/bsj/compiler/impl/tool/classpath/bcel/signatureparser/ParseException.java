package edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.signatureparser;

/**
 * Raised by the signature parser whenever a parse error occurs.
 * @author Zachary Palmer
 */
public class ParseException extends Exception
{
	private static final long serialVersionUID = 1L;

	public ParseException()
	{
		super();
	}

	public ParseException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ParseException(String message)
	{
		super(message);
	}

	public ParseException(Throwable cause)
	{
		super(cause);
	}

}
