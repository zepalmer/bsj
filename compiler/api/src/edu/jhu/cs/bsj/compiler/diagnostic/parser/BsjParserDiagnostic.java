package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.JavaFileObject;

import edu.jhu.cs.bsj.compiler.diagnostic.AbstractBsjDiagnostic;

/**
 * This type of diagnostic represents those diagnostics which are produced by the BSJ parser.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of the source of this diagnostic.
 */
public abstract class BsjParserDiagnostic<T extends JavaFileObject> extends AbstractBsjDiagnostic<T>
{
	/**
	 * The rule in which this diagnostic occurred.
	 */
	private String ruleName;
	
	/**
	 * @param rule The rule which produced this diagnostic.
	 * @see AbstractBsjDiagnostic#AbstractBsjDiagnostic(long, long, JavaFileObject, String, javax.tools.Diagnostic.Kind)
	 */
	public BsjParserDiagnostic(long lineNumber, long columnNumber, T source, String code, Kind kind, String rule)
	{
		super(lineNumber, columnNumber, source, code, kind);
		this.ruleName = rule;
	}

	/**
	 * Retrieves the name of the rule in which this diagnostic was produced.
	 * @return The name of this diagnostic's rule.
	 */
	public String getRuleName()
	{
		return ruleName;
	}

	@Override
	protected List<Object> getMessageArgs()
	{
		return new ArrayList<Object>(Arrays.asList(this.ruleName));
	}
}
