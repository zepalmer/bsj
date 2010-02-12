package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.Arrays;
import java.util.List;

import javax.tools.JavaFileObject;

/**
 * Represents an invalid literal.  Invalid literals are those which are out of range for their corresponding type.
 * @author Zachary Palmer
 *
 * @param <T>
 */
public class InvalidFloatingPointLiteralDiagnostic<T extends JavaFileObject> extends BsjParserDiagnostic<T>
{
	/**
	 * The possible causes of a floating point parse failure. Note that other causes (such as a parse failure due to
	 * invalid characters in the literal) will be reported as token errors and so do not appear here.
	 */
	public static enum FailureType
	{
		/** Indicates that the parse of the floating point literal failed because the value rounded to zero. */
		TOO_SMALL("bsj.parser.error.invalidFloatingPointLiteral.tooSmall"),
		/** Indicates that the parse of the floating point literal failed because the value rounded to infinity. */
		TOO_LARGE("bsj.parser.error.invalidFloatingPointLiteral.tooLarge");
		
		/** The code for this failure type. */
		private String code;

		private FailureType(String code)
		{
			this.code = code;
		}

		public String getCode()
		{
			return code;
		}
	}
	
	/** The text of the invalid literal. */
	private String literalText;
	/** The type of failure for this diagnostic. */
	private FailureType type;

	public InvalidFloatingPointLiteralDiagnostic(long lineNumber, long columnNumber, T source, String rule,
			String literalText, FailureType type)
	{
		super(lineNumber, columnNumber, source, type.getCode(), Kind.ERROR, rule);
		this.literalText = literalText;
	}
	
	/**
	 * Retrieves text of the invalid literal.
	 * @return The text of the invalid literal.
	 */
	public String getLiteralText()
	{
		return literalText;
	}

	/**
	 * Retrieves the type of this diagnostic's failure.
	 * @return The diagnostic's failure type.
	 */
	public FailureType getType()
	{
		return type;
	}

	@Override
	protected List<Object> getMessageArgs()
	{
		List<Object> args = super.getMessageArgs();
		args.addAll(Arrays.asList(literalText));
		return args;
	}
}
