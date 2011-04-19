package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.inference;

/**
 * The parent of all exception types thrown when method type inference fails.
 * 
 * @author Zachary Palmer
 */
public abstract class AbstractMethodTypeInferenceException extends Exception
{
    private static final long serialVersionUID = 1L;

    public AbstractMethodTypeInferenceException()
    {
        super();
    }

    public AbstractMethodTypeInferenceException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public AbstractMethodTypeInferenceException(String message)
    {
        super(message);
    }

    public AbstractMethodTypeInferenceException(Throwable cause)
    {
        super(cause);
    }

}
