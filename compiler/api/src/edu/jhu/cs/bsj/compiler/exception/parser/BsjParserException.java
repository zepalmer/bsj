package edu.jhu.cs.bsj.compiler.exception.parser;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.exception.BsjCompilerException;

/**
 * This compiler error subclass is extended by those exceptions which relate to some form of parse failure.  If an
 * instance of this class is instantiated, it represents a general parse error for which no additional information is
 * available.
 * @author Zachary Palmer
 */
public class BsjParserException extends BsjCompilerException
{
	private static final long serialVersionUID = 1L;
	
	/** The rule which was being parsed when the failure occurred. */
	private String rule;

	public BsjParserException(String rule, BsjSourceLocation location)
	{
		super(location);
		this.rule = rule;
	}
	
	public BsjParserException(String rule, BsjSourceLocation location, Throwable cause)
	{
		super(location, cause);
		this.rule = rule;
	}

	/**
	 * Retrieves the name of the rule which was being parsed when this error occurred.
	 * @return The name of the rule which was being parsed when this error occurred.
	 */
	public String getRule()
	{
		return rule;
	}

	/**
	 * This overridden message generator produces a human-readable debug message describing this parse exception.
	 */
	@Override
	public String getMessage()
	{
		return this.rule + " @ " + this.getLocation();
	}
}
