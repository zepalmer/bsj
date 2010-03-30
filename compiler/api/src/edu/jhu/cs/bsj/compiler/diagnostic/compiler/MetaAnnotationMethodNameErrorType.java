package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

/**
 * Enumerates the different types of errors for meta-annotation methods which are reported via diagnostics.
 * @author Zachary Palmer
 */
public enum MetaAnnotationMethodNameErrorType
{
	/** Used when a getter or setter has a name which is shorter than four characters. */
	TOO_SHORT,
	/** Used when a getter or setter does not start with "get" or "set", respectively. */
	WRONG_PREFIX,
	/** Used when a getter or setter has a fourth character which is not upper-case. */
	BAD_FOURTH_CHARACTER
}
