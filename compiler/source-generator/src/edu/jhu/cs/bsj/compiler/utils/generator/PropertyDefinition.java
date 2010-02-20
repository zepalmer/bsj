package edu.jhu.cs.bsj.compiler.utils.generator;

/**
 * This class represents a property definition.
 * 
 * @author Zachary Palmer
 */
public class PropertyDefinition
{
	public static enum Mode
	{
		/** A normal property. */
		NORMAL,
		/** A read-only property; no getter is generated. */
		READ_ONLY,
		/**
		 * A "skip-make" property. No getter is generated. A variant of each factory method appears without this
		 * property as a parameter.
		 */
		SKIP,
		/** A hidden property. No getter is generated. Factory methods never accept this as a parameter. */
		HIDE;
		// TODO: restricted properties?  Not stored on the nodes themselves but with some central authority?
	}

	private String name;
	private String baseType;
	private String typeArg;
	private Mode mode;
	private String description;
	private String defaultExpression;

	public PropertyDefinition(String name, String baseType, String typeArg, Mode mode, String description,
			String defaultExpression)
	{
		super();
		this.name = name;
		this.baseType = baseType;
		this.typeArg = typeArg;
		this.mode = mode;
		this.description = description;
		this.defaultExpression = defaultExpression;
	}

	public boolean isSkipMake()
	{
		return this.mode == Mode.SKIP || this.mode == Mode.HIDE;
	}

	public boolean isReadOnly()
	{
		return this.mode != Mode.NORMAL;
	}

	public boolean isHide()
	{
		return this.mode == Mode.HIDE;
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
}
