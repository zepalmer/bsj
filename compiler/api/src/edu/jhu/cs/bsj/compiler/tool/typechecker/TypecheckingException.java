package edu.jhu.cs.bsj.compiler.tool.typechecker;

/**
 * Indicates a failure in typechecking.  More information about the specific failure can be obtained from the diagnostic
 * listener which was provided to the corresponding typechecker when it was instantiated.
 * @author Zachary Palmer
 */
public class TypecheckingException extends Exception
{
    private static final long serialVersionUID = 0L;

    public TypecheckingException()
    {
        super();
    }

    public TypecheckingException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public TypecheckingException(String message)
    {
        super(message);
    }

    public TypecheckingException(Throwable cause)
    {
        super(cause);
    }
}
