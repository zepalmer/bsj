package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.tools.JavaFileObject;

public class DuplicateModifierDiagnostic<T extends JavaFileObject> extends BsjParserDiagnostic<T>
{
	/** The code for this diagnostic. */
	public static final String CODE = "bsj.parser.error.duplicateModifier";
	
	/** The modifier which was duplicated. */
	private String modifier;

	public DuplicateModifierDiagnostic(long lineNumber, long columnNumber, T source, String rule, String modifier)
	{
		super(lineNumber, columnNumber, source, CODE, Kind.ERROR, rule);
		this.modifier = modifier;
	}
	
	/**
	 * Retrieves the modifier which was duplicated.
	 * @return The modifier which was duplicated.
	 */
	public String getModifier()
	{
		return modifier;
	}
}
