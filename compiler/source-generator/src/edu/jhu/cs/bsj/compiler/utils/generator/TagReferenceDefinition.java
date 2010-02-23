package edu.jhu.cs.bsj.compiler.utils.generator;

/**
 * Represents the use of a tag in a type definition.
 * 
 * @author Zachary Palmer
 */
public class TagReferenceDefinition
{
	/** The type of the tag. */
	private String name;
	/** The type argument of the tag. */
	private String typeArg;

	public TagReferenceDefinition(String name, String typeArg)
	{
		super();
		this.name = name;
		this.typeArg = typeArg;
	}

	public String getName()
	{
		return name;
	}

	public String getTypeArg()
	{
		return typeArg;
	}

}
