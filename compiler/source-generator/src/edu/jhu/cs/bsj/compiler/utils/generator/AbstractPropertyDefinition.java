package edu.jhu.cs.bsj.compiler.utils.generator;


public abstract class AbstractPropertyDefinition<T extends AbstractPropertyDefinition<T>>
{
	private String name;
	private String baseType;
	private String typeArg;
	private String description;
	private String defaultExpression;
	private boolean allowUnion;

	private ParameterizedPropertyBasedHierarchyDefinition<?, ?> parentDef;

	public AbstractPropertyDefinition(String name, String baseType, String typeArg, String description,
			String defaultExpression, boolean allowUnion)
	{
		super();
		this.name = name;
		this.baseType = baseType;
		this.typeArg = typeArg;
		this.description = description;
		this.defaultExpression = defaultExpression;
		this.allowUnion = allowUnion;
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

	public boolean isAllowUnion()
	{
		return allowUnion;
	}

	public String toString()
	{
		return "PropDef:" + getName() + ":" + getFullType() + "(" + getParentDef() + ")";
	}

	public boolean isNodeType()
	{
		// See if the type is a node
		if (this.getBaseType().endsWith("Node"))
			return true;

		// See if the type is a parameter with an upper bound of a node
		if (this.getParentDef().getTypeParameter() != null)
		{
			String[] components = this.getParentDef().getTypeParameter().split("\\s+");
			if (components.length >= 3 && components[1].equals("extends") && components[0].equals(this.getBaseType()))
			{
				int index = 2;
				while (index < components.length)
				{
					if (!components[index].equals("&"))
					{
						if (components[index].endsWith("Node"))
						{
							return true;
						}
					}
					index++;
				}
			}
		}

		return false;
	}
	
	public boolean isWrappable()
	{
		return this.isNodeType() && this.isAllowUnion();
	}

	public abstract T deriveWithBaseType(String name);

	public abstract T deriveWithTypeArg(String arg);

	public ParameterizedPropertyBasedHierarchyDefinition<?, ?> getParentDef()
	{
		return parentDef;
	}

	public void setParentDef(ParameterizedPropertyBasedHierarchyDefinition<?, ?> parentDef)
	{
		this.parentDef = parentDef;
	}
}