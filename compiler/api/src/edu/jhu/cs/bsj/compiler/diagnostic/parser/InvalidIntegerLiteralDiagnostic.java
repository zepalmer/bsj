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
public class InvalidIntegerLiteralDiagnostic<T extends JavaFileObject> extends BsjParserDiagnostic<T>
{
	/** The code for this diagnostic. */
	public static final String CODE = "bsj.parser.error.invalidIntegerLiteral";
	
	/** The text of the invalid literal. */
	private String literalText;

	public InvalidIntegerLiteralDiagnostic(long lineNumber, long columnNumber, T source, String rule,
			String literalText)
	{
		super(lineNumber, columnNumber, source, CODE, Kind.ERROR, rule);
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

	@Override
	protected List<Object> getMessageArgs()
	{
		List<Object> args = super.getMessageArgs();
		args.addAll(Arrays.asList(literalText));
		return args;
	}
}
