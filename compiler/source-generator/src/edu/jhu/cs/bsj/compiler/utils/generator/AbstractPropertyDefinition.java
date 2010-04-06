package edu.jhu.cs.bsj.compiler.utils.generator;

public abstract class AbstractPropertyDefinition<T extends AbstractPropertyDefinition<T>>
{
	private String name;
	private String baseType;
	private String typeArg;
	private String description;
	private String defaultExpression;

	public AbstractPropertyDefinition(String name, String baseType, String typeArg, String description,
			String defaultExpression)
	{
		super();
		this.name = name;
		this.baseType = baseType;
		this.typeArg = typeArg;
		this.description = description;
		this.defaultExpression = defaultExpression;
	}

	public AbstractPropertyDefinition()
	{
		super();
	}

	public String getName()
	{
		return name;
	}

	public String getBaseType()
	{
		return baseType;
	}

	public String getTypeArg()
	{
		return typeArg;
	}

	public String getDescription()
	{
		return description;
	}

	public String getDefaultExpression()
	{
		return defaultExpression;
	}

	public String getFullType()
	{
		if (this.typeArg == null)
		{
			return getBaseType();
		} else
		{
			return getBaseType() + "<" + getTypeArg() + ">";
		}
	}

	public String toString()
	{
		return "PropDef:" + getName() + ":" + getFullType();
	}
	
	public abstract T deriveWithBaseType(String name);
	
	public abstract T deriveWithTypeArg(String arg);
}