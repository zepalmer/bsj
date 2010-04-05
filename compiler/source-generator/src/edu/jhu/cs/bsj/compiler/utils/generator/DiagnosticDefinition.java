package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * This class represents the definition for a BSJ diagnostic.
 * 
 * @author Zachary Palmer
 */
public class DiagnosticDefinition extends
		PropertyBasedHierarchyDefinition<DiagnosticDefinition, DiagnosticPropertyDefinition>
{
	private String name;
	private String superName;
	private GenerationProfile profile;
	private List<DiagnosticPropertyDefinition> properties;
	private List<String> messagePropertyExpressions;
	private String docString;
	private String code;

	private DiagnosticDefinition parent;
	private Map<String, DiagnosticDefinition> namespaceMap;

	public DiagnosticDefinition(String name, String superName, GenerationProfile profile,
			List<DiagnosticPropertyDefinition> properties, List<String> messagePropertyExpressions, String docString, String code)
	{
		super();
		this.name = name;
		this.superName = superName;
		this.profile = profile;
		this.properties = properties;
		this.messagePropertyExpressions = messagePropertyExpressions;
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

	public GenerationProfile getProfile()
	{
		return profile;
	}

	public List<DiagnosticPropertyDefinition> getProperties()
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

	public Map<String, DiagnosticDefinition> getNamespaceMap()
	{
		return namespaceMap;
	}

	public void setNamespaceMap(Map<String, DiagnosticDefinition> namespaceMap)
	{
		this.namespaceMap = namespaceMap;
	}

	@Override
	public List<TagReferenceDefinition> getTags()
	{
		return Collections.emptyList();
	}

	public List<String> getMessagePropertyExpressions()
	{
		return messagePropertyExpressions;
	}
}
