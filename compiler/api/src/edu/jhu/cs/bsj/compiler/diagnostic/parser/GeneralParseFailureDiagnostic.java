package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.Arrays;
import java.util.List;

import javax.tools.JavaFileObject;

/**
 * Represents a diagnostic which indicates that the parser encountered a segment of the token stream it did not know how
 * to interpret.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of source for this diagnostic.
 */
public class GeneralParseFailureDiagnostic<T extends JavaFileObject> extends BsjParserDiagnostic<T>
{
	/** The code for this diagnostic. */
	public static final String CODE = "bsj.parser.error.generalParseFailure";

	/** The type of the token at which the problems started. */
	private String tokenType;
	/** The text of the token at which the problems started. */
	private String tokenText;

	public GeneralParseFailureDiagnostic(long lineNumber, long columnNumber, T source, String rule,
			String tokenType, String tokenText)
	{
		super(lineNumber, columnNumber, source, CODE, Kind.ERROR, rule);
		this.tokenType = tokenType;
		this.tokenText = tokenText;
	}

	/**
	 * Retrieves the name of the type of token which was the start of parsing problems.
	 * @return The type of token which was the start of parsing problems.
	 */
	public String getTokenType()
	{
		return tokenType;
	}

	/**
	 * Retrieves the text of the token which was the start of parsing problems.
	 * @return The text of the error token.
	 */
	public String getTokenText()
	{
		return tokenText;
	}

	@Override
	protected List<Object> getMessageArgs()
	{
		List<Object> args = super.getMessageArgs();
		args.addAll(Arrays.asList(tokenType, tokenText));
		return args;
	}
}
