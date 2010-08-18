package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.Collection;

/**
 * Used to describe a single parse rule.
 * @author Zachary Palmer
 */
public class ParseRuleDefinition
{
	private String name;
	private Collection<OutputTypeDefinition> outputTypes;

	public ParseRuleDefinition(String name, Collection<OutputTypeDefinition> outputTypes)
	{
		super();
		this.name = name;
		this.outputTypes = outputTypes;
	}

	public String getName()
	{
		return name;
	}

	public Collection<OutputTypeDefinition> getOutputTypes()
	{
		return outputTypes;
	}
}
