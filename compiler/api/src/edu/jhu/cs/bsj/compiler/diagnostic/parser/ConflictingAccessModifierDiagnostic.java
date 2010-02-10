package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.tools.JavaFileObject;

/**
 * Represents a diagnostic which indicates conflicting access modifiers.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of source for this diagnostic.
 */
public class ConflictingAccessModifierDiagnostic<T extends JavaFileObject> extends BsjParserDiagnostic<T>
{
	/** The code for this diagnostic. */
	public static final String CODE = "bsj.parser.error.conflictingAccessModifier";

	/** The first access modifier which conflicts. */
	private String firstModifier;
	/** The second access modifier which conflicts. */
	private String secondModifier;

	public ConflictingAccessModifierDiagnostic(long lineNumber, long columnNumber, T source, String rule,
			String firstModifier, String secondModifier)
	{
		super(lineNumber, columnNumber, source, CODE, Kind.ERROR, rule);
		this.firstModifier = firstModifier;
		this.secondModifier = secondModifier;
	}

	/**
	 * Retrieves the first modifier which conflicted.
	 * 
	 * @return The first conflicting modifier.
	 */
	public String getFirstModifier()
	{
		return firstModifier;
	}

	/**
	 * Retrieves the second modifier which conflicted.
	 * 
	 * @return The second conflicting modifier.
	 */
	public String getSecondModifier()
	{
		return secondModifier;
	}
}
