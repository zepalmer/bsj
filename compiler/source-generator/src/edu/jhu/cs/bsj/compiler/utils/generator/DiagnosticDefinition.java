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
		ParameterizedPropertyBasedHierarchyDefinition<DiagnosticDefinition, DiagnosticPropertyDefinition>
{
	private GenerationProfile profile;
	private DiagnosticExceptionDefinition exception;
	private List<DiagnosticPropertyDefinition> properties;
	private List<String> messagePropertyExpressions;
	private String docString;
	private String code;

	private DiagnosticDefinition parent;
	private Map<String, DiagnosticDefinition> namespaceMap;

	public DiagnosticDefinition(String baseName, String typeParameter, String superName, String superTypeArg,
			GenerationProfile profile, DiagnosticExceptionDefinition exception,
			List<DiagnosticPropertyDefinition> properties, List<String> messagePropertyExpressions, String docString,
			String code)
	{
		super(baseName, typeParameter, superName, superTypeArg, Collections.<TagReferenceDefinition>emptyList());
		this.profile = profile;
		this.exception = exception;
		this.properties = properties;
		this.messagePropertyExpressions = messagePropertyExpressions;
		this.docString = docString;
		this.code = code;
	}

	public GenerationProfile getProfile()
	{
		return profile;
	}
	
	public DiagnosticExceptionDefinition getException()
	{
		return exception;
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

	public List<String> getMessagePropertyExpressions()
	{
		return messagePropertyExpressions;
	}

	@Override
	public String getName()
	{
		return getBaseName();
	}
}
