package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.List;
import java.util.Map;

/**
 * This class represents a type definition.
 * 
 * @author Zachary Palmer
 */
public class TypeDefinition
{
	enum Mode
	{
		CONCRETE, ABSTRACT, INTERFACE
	}

	private String baseName;
	private String typeParameter;
	private String superName;
	private String superTypeArg;
	private String interfacePackage;
	private String classPackage;
	private List<String> tags;
	private List<PropertyDefinition> properties;
	private List<String> includes;
	private String docString;
	private List<String> toStringLines;
	private Map<String, String> overrideMap;
	private boolean genConstructor;
	private boolean genChildren;
	private Mode mode;

	public TypeDefinition(String baseName, String typeParameter, String superName, String superTypeArg,
			String interfacePackage, String classPackage, List<String> tags, List<PropertyDefinition> properties,
			List<String> includes, String docString, List<String> toStringLines, Map<String, String> overrideMap,
			boolean genConstructor, boolean genChildren, Mode mode)
	{
		super();
		this.baseName = baseName;
		this.typeParameter = typeParameter;
		this.superName = superName;
		this.superTypeArg = superTypeArg;
		this.interfacePackage = interfacePackage;
		this.classPackage = classPackage;
		this.tags = tags;
		this.properties = properties;
		this.includes = includes;
		this.docString = docString;
		this.toStringLines = toStringLines;
		this.overrideMap = overrideMap;
		this.genConstructor = genConstructor;
		this.genChildren = genChildren;
		this.mode = mode;
	}

	public String getFullName()
	{
		if (typeParameter == null)
		{
			return baseName;
		} else
		{
			return baseName + "<" + typeParameter + ">";
		}
	}

	public String getFullSuper()
	{
		if (superTypeArg == null)
		{
			return superName;
		} else
		{
			return superName + "<" + superTypeArg + ">";
		}
	}
	
	public String getUnboundedTypeParameter()
	{
		if (typeParameter == null)
		{
			return null;
		} else
		{
			if (typeParameter.indexOf(' ')!=-1)
			{
				return typeParameter.substring(0, typeParameter.indexOf(' '));
			} else
			{
				return typeParameter;
			}
		}
	}

	public String getUnboundedSuperTypeArg()
	{
		if (superTypeArg == null)
		{
			return null;
		} else
		{
			if (superTypeArg.indexOf(' ')!=-1)
			{
				return superTypeArg.substring(0, superTypeArg.indexOf(' '));
			} else
			{
				return superTypeArg;
			}
		}
	}

	public String getTypeParameterWithDelimiters()
	{
		if (typeParameter == null)
		{
			return null;
		} else
		{
			return "<" + typeParameter + ">";
		}
	}
	
	public String getNameWithTypeParameters()
	{
		if (typeParameter == null)
		{
			return getBaseName();
		} else
		{
			return getBaseName() + "<" + getUnboundedTypeParameter() + ">";
		}
	}

	public String getBaseName()
	{
		return baseName;
	}

	public String getTypeParameter()
	{
		return typeParameter;
	}

	public String getBaseSuperName()
	{
		return superName;
	}

	public String getSuperTypeArg()
	{
		return superTypeArg;
	}
	
	public String getInterfacePackage()
	{
		return interfacePackage;
	}

	public String getClassPackage()
	{
		return classPackage;
	}

	public List<String> getTags()
	{
		return tags;
	}

	public List<PropertyDefinition> getProperties()
	{
		return properties;
	}

	public List<String> getIncludes()
	{
		return includes;
	}

	public String getDocString()
	{
		return docString;
	}

	public List<String> getToStringLines()
	{
		return toStringLines;
	}

	public Map<String, String> getOverrideMap()
	{
		return overrideMap;
	}

	public boolean isGenConstructor()
	{
		return genConstructor;
	}

	public boolean isGenChildren()
	{
		return genChildren;
	}

	public Mode getMode()
	{
		return mode;
	}
	
	public String toString()
	{
		return "TypeDef:" + getFullName();
	}
}
