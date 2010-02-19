package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents a type definition.
 * 
 * @author Zachary Palmer
 */
public class TypeDefinition extends PropertyBasedHierarchyDefinition<TypeDefinition>
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
	private FactoryProfile factoryProfile;
	private List<String> interfaces; // used to denote non-tag interfaces such as List<T>
	private List<String> tags;
	private List<PropertyDefinition> properties;
	private List<String> includes;
	private String docString;
	private List<String> toStringLines;
	private Map<String, String> factoryOverrideMap;
	private Map<String, String> constructorOverrideMap;
	private boolean genConstructor;
	private boolean genChildren;
	private List<FactoryMethodDefinition> factoryMethods;
	private Mode mode;
	
	private TypeDefinition parent;

	public TypeDefinition(String baseName, String typeParameter, String superName, String superTypeArg,
			String interfacePackage, String classPackage, FactoryProfile factoryProfile, List<String> interfaces, List<String> tags, List<PropertyDefinition> properties,
			List<String> includes, String docString, List<String> toStringLines,
			Map<String, String> factoryOverrideMap, Map<String, String> constructorOverrideMap, boolean genConstructor,
			boolean genChildren, List<FactoryMethodDefinition> factoryMethods, Mode mode)
	{
		super();
		this.baseName = baseName;
		this.typeParameter = typeParameter;
		this.superName = superName;
		this.superTypeArg = superTypeArg;
		this.interfacePackage = interfacePackage;
		this.classPackage = classPackage;
		this.factoryProfile = factoryProfile;
		this.interfaces = interfaces;
		this.tags = tags;
		this.properties = properties;
		this.includes = includes;
		this.docString = docString;
		this.toStringLines = toStringLines;
		this.factoryOverrideMap = factoryOverrideMap;
		this.constructorOverrideMap = constructorOverrideMap;
		this.genConstructor = genConstructor;
		this.genChildren = genChildren;
		this.factoryMethods = factoryMethods;
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

	public FactoryProfile getFactoryProfile()
	{
		return factoryProfile;
	}

	public List<String> getInterfaces()
	{
		return interfaces;
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

	public Map<String, String> getFactoryOverrideMap()
	{
		return factoryOverrideMap;
	}

	public Map<String, String> getConstructorOverrideMap()
	{
		return constructorOverrideMap;
	}

	public boolean isGenConstructor()
	{
		return genConstructor;
	}

	public boolean isGenChildren()
	{
		return genChildren;
	}
	
	public String getSuperName()
	{
		return superName;
	}

	public List<FactoryMethodDefinition> getFactoryMethods()
	{
		return factoryMethods;
	}

	public Mode getMode()
	{
		return mode;
	}
	
	@Override
	public String getName()
	{
		return getBaseName();
	}

	@Override
	public TypeDefinition getParent()
	{
		return this.parent;
	}

	@Override
	public void setParent(TypeDefinition parent)
	{
		this.parent = parent;
	}

	public String toString()
	{
		return "TypeDef:" + getFullName();
	}

	@Override
	public List<PropertyDefinition> getRecursiveProperties(boolean parentFirst)
	{
		List<PropertyDefinition> props = super.getRecursiveProperties(parentFirst);
		Map<String,String> typeArgMap = new HashMap<String, String>();
		TypeDefinition def = this;
		while (def != null && def.getParent() != null)
		{
			if (def.getSuperTypeArg() != null && def.getParent().getTypeParameter() != null)
			{
				String typeParam = def.getParent().getTypeParameter();
				if (typeParam.indexOf(' ') != -1)
					typeParam = typeParam.substring(0, typeParam.indexOf(' '));
				typeArgMap.put(typeParam, def.getSuperTypeArg());
			}
			def = def.getParent();
		}
		
		for (int i=0;i<props.size();i++)
		{
			PropertyDefinition propdef = props.get(i);
			if (typeArgMap.containsKey(propdef.getBaseType()))
			{
				propdef = new PropertyDefinition(propdef.getName(), typeArgMap.get(propdef.getBaseType()), propdef.getTypeArg(),
						propdef.getMode(), propdef.getDescription(), propdef.getDefaultExpression());
			}
			if (typeArgMap.containsKey(propdef.getTypeArg()))
			{
				propdef = new PropertyDefinition(propdef.getName(), propdef.getBaseType(), typeArgMap.get(propdef.getTypeArg()),
						propdef.getMode(), propdef.getDescription(), propdef.getDefaultExpression());
			}
			props.set(i, propdef);
		}
		
		return props;
	}
}
