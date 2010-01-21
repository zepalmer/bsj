package edu.jhu.cs.bsj.compiler.exception.parser;

import sun.awt.CausedFocusEvent.Cause;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * Represents an error in which the parsing of a floating point literal failed.
 * 
 * @author Zachary Palmer
 */
public class InvalidFloatingPointLiteralException extends BsjParserException
{
	private static final long serialVersionUID = 1L;

	/**
	 * The possible causes of a floating point parse failure. Note that other causes (such as a parse failure due to
	 * invalid characters in the literal) will be reported as token errors and so do not appear here.
	 */
	public static enum FailureType
	{
		/** Indicates that the parse of the floating point literal failed because the value rounded to zero. */
		TOO_SMALL,
		/** Indicates that the parse of the floating point literal failed because the value rounded to infinity. */
		TOO_LARGE
	}

	/** The original literal string. */
	private String literalString;
	/** The cause of the parse failure. */
	private FailureType failureType;

	/**
	 * Creates a new {@link InvalidFloatingPointLiteralException}.
	 * 
	 * @param location The location at which the error occurred.
	 * @param literalString The literal string which produced the parse failure.
	 * @param cause The {@link Cause} of the exception.
	 */
	public InvalidFloatingPointLiteralException(String rule, BsjSourceLocation location, String literalString,
			FailureType failureType)
	{
		super(rule, location);
		this.literalString = literalString;
		this.failureType = failureType;
	}

	public String getLiteralString()
	{
		return literalString;
	}

	public FailureType getFailureType()
	{
		return failureType;
	}
}
