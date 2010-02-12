package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.Arrays;
import java.util.List;

import javax.tools.JavaFileObject;

public class InvalidModifierDiagnostic<T extends JavaFileObject> extends BsjParserDiagnostic<T>
{
	/** The code for this diagnostic. */
	public static final String CODE = "bsj.parser.error.invalidModifier";
	
	/** The modifier which was used incorrectly. */
	private String modifier;

	public InvalidModifierDiagnostic(long lineNumber, long columnNumber, T source, String rule, String modifier)
	{
		super(lineNumber, columnNumber, source, CODE, Kind.ERROR, rule);
		this.modifier = modifier;
	}
	
	/**
	 * Retrieves the modifier which was used incorrectly.
	 * @return The modifier which was used incorrectly.
	 */
	public String getModifier()
	{
		return modifier;
	}

	@Override
	protected List<Object> getMessageArgs()
	{
		List<Object> args = super.getMessageArgs();
		args.addAll(Arrays.asList(modifier));
		return args;

	}
}
