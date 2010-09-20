package edu.jhu.cs.bsj.compiler.ast.exception;

import edu.jhu.cs.bsj.compiler.ast.node.SimpleNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;

/**
 * This type of {@link MetaprogramExecutionFailureException} specifically indicates that a {@link SpliceNode} was
 * treated like a normal node.  For instance, a {@link SpliceNode} acting as a {@link SimpleNameNode} will raise this
 * exception if its identifier is accessed.
 * @author Zachary Palmer
 */
public class SpliceNodeAccessException extends MetaprogramExecutionFailureException
{
	private static final long serialVersionUID = 1L;

	public SpliceNodeAccessException()
	{
		super();
	}

	public SpliceNodeAccessException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public SpliceNodeAccessException(String message)
	{
		super(message);
	}

	public SpliceNodeAccessException(Throwable cause)
	{
		super(cause);
	}
}
