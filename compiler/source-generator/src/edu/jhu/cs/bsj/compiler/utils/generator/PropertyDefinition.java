package edu.jhu.cs.bsj.compiler.utils.generator;

/**
 * This class represents a property definition.
 * @author Zachary Palmer
 */
public class PropertyDefinition
{
	public static enum Mode
	{
		NORMAL,
		READ_ONLY,
		SKIP
	}

	private String name;
	private String baseType;
	private String typeArg;
	private Mode mode;
	private String description;
	
	public PropertyDefinition(String name, String baseType, String typeArg, Mode mode, String description)
	{
		super();
		this.name = name;
		this.baseType = baseType;
		this.typeArg = typeArg;
		this.mode = mode;
		this.description = description;
	}
	
	public boolean isSkipMake()
	{
		return this.mode == Mode.SKIP;
	}
	
	public boolean isReadOnly()
	{
		return this.mode != Mode.NORMAL;
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

	public Mode getMode()
	{
		return mode;
	}

	public String getDescription()
	{
		return description;
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
}
