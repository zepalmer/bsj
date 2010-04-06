package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents a type definition.
 * 
 * @author Zachary Palmer
 */
public class TypeDefinition extends ParameterizedPropertyBasedHierarchyDefinition<TypeDefinition, PropertyDefinition>
{
	enum Mode
	{
		CONCRETE,
		ABSTRACT,
		INTERFACE
	}

	private GenerationProfile profile;
	private List<String> interfaces; // used to denote non-tag interfaces such as List<T>
	private List<ConstantDefinition> constants;
	private List<PropertyDefinition> properties;
	private List<String> includes;
	private String docString;
	private List<String> toStringLines;
	private Map<String, String> factoryOverrideMap;
	private Map<String, String> constructorOverrideMap;
	private boolean genConstructor;
	private boolean genChildren;
	private boolean genReplace;
	private List<FactoryMethodDefinition> factoryMethods;
	private Mode mode;

	private TypeDefinition parent;
	private Map<String, TypeDefinition> namespaceMap;

	public TypeDefinition(String baseName, String typeParameter, String superName, String superTypeArg,
			GenerationProfile profile, List<String> interfaces, List<TagReferenceDefinition> tags,
			List<ConstantDefinition> constants, List<PropertyDefinition> properties, List<String> includes,
			String docString, List<String> toStringLines, Map<String, String> factoryOverrideMap,
			Map<String, String> constructorOverrideMap, boolean genConstructor, boolean genChildren,
			boolean genReplace, List<FactoryMethodDefinition> factoryMethods, Mode mode)
	{
		super(baseName, typeParameter, superName, superTypeArg, tags);
		this.profile = profile;
		this.interfaces = interfaces;
		this.constants = constants;
		this.properties = properties;
		this.includes = includes;
		this.docString = docString;
		this.toStringLines = toStringLines;
		this.factoryOverrideMap = factoryOverrideMap;
		this.constructorOverrideMap = constructorOverrideMap;
		this.genConstructor = genConstructor;
		this.genChildren = genChildren;
		this.genReplace = genReplace;
		this.factoryMethods = factoryMethods;
		this.mode = mode;
	}

	public GenerationProfile getProfile()
	{
		return profile;
	}

	public List<String> getInterfaces()
	{
		return interfaces;
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

	public boolean isGenReplace()
	{
		return genReplace;
	}

	public List<FactoryMethodDefinition> getFactoryMethods()
	{
		return factoryMethods;
	}

	public Mode getMode()
	{
		return mode;
	}

	public List<ConstantDefinition> getConstants()
	{
		return constants;
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

	public Map<String, TypeDefinition> getNamespaceMap()
	{
		return namespaceMap;
	}

	public void setNamespaceMap(Map<String, TypeDefinition> namespaceMap)
	{
		this.namespaceMap = namespaceMap;
	}

	public Map<String, String> getRecursiveFactoryOverrideMap()
	{
		Map<String, String> map = new HashMap<String, String>();
		map.putAll(this.getFactoryOverrideMap());
		for (TagReferenceDefinition tag : this.getTags())
		{
			map.putAll(this.namespaceMap.get(tag.getName()).getRecursiveFactoryOverrideMap());
		}
		if (this.getParent() != null)
		{
			map.putAll(this.getParent().getRecursiveFactoryOverrideMap());
		}
		return map;
	}
}
