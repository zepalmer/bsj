package edu.jhu.cs.bsj.compiler.ast.exception;

/**
 * This exception is thrown when a meta-annotation node cannot instantiate its representative object.  Information about
 * the cause of this exception is reported to the diagnostic listener provided in the call.
 * @author Zachary Palmer
 */
public class MetaAnnotationInstantiationFailureException extends Exception
{
	private static final long serialVersionUID = 1L;
}
