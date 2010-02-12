package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.List;

/**
 * This class represents the definition for a BSJ diagnostic.
 * @author Zachary Palmer
 */
public class DiagnosticDefinition extends PropertyBasedHierarchyDefinition<DiagnosticDefinition>
{
	private String name;
	private String superName;
	private String classPackage;
	private List<PropertyDefinition> properties;
	private String docString;
	private String code;
	
	private DiagnosticDefinition parent;
	
	public DiagnosticDefinition(String name, String superName, String classPackage, List<PropertyDefinition> properties,
			String docString, String code)
	{
		super();
		this.name = name;
		this.superName = superName;
		this.classPackage = classPackage;
		this.properties = properties;
		this.docString = docString;
		this.code = code;
	}

	public String getName()
	{
		return name;
	}

	public String getSuperName()
	{
		return superName;
	}

	public String getClassPackage()
	{
		return classPackage;
	}

	public List<PropertyDefinition> getProperties()
	{
		return properties;
	}

	public String getDocString()
	{
		return docString;
	}

	public String getCode()
	{
		return code;
	}

	@Override
	public DiagnosticDefinition getParent()
	{
		return this.parent;
	}

	@Override
	public void setParent(DiagnosticDefinition parent)
	{
		this.parent = parent;
	}
}
