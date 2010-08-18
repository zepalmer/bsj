package edu.jhu.cs.bsj.compiler.utils.generator;

/**
 * Used to describe an output type for a parse rule.
 * @author Zachary Palmer
 */
public class OutputTypeDefinition
{
	private String name;
	
	private TypeDefinition type;

	public OutputTypeDefinition(String name)
	{
		super();
		this.name = name;
	}

	public TypeDefinition getType()
	{
		return type;
	}

	public void setType(TypeDefinition type)
	{
		this.type = type;
	}

	public String getName()
	{
		return name;
	}
}
