package edu.jhu.cs.bsj.compiler.exception;

/**
 * A base class for BSJ compilation errors.
 * @author Zachary Palmer
 */
public abstract class BsjCompilerException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public BsjCompilerException()
	{
		super();
	}
	
	public BsjCompilerException(Throwable cause)
	{
		super(cause);
	}
}
