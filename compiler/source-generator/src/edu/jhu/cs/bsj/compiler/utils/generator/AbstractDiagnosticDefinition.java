package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * This class represents the definition for a BSJ diagnostic.
 * 
 * @author Zachary Palmer
 */
public class AbstractDiagnosticDefinition<T extends AbstractDiagnosticDefinition<T>> extends
		ParameterizedPropertyBasedHierarchyDefinition<T, DiagnosticPropertyDefinition>
{
	private GenerationProfile profile;
	private List<DiagnosticPropertyDefinition> properties;
	private List<MessagePropertyExpressionDefinition> messagePropertyExpressions;
	private String docString;
	private String code;

	private T parent;
	private Map<String, T> namespaceMap;

	public AbstractDiagnosticDefinition(String baseName, String typeParameter, String superName, String superTypeArg,
			GenerationProfile profile, List<DiagnosticPropertyDefinition> properties,
			List<MessagePropertyExpressionDefinition> messagePropertyExpressions, String docString, String code)
	{
		super(baseName, typeParameter, superName, superTypeArg, Collections.<TagReferenceDefinition> emptyList());
		this.profile = profile;
		this.properties = properties;
		this.messagePropertyExpressions = messagePropertyExpressions;
		this.docString = docString;
		this.code = code;
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
	public T getParent()
	{
		return this.parent;
	}

	@Override
	public void setParent(T parent)
	{
		this.parent = parent;
	}

	public Map<String, T> getNamespaceMap()
	{
		return namespaceMap;
	}

	public void setNamespaceMap(Map<String, T> namespaceMap)
	{
		this.namespaceMap = namespaceMap;
	}

	public List<MessagePropertyExpressionDefinition> getMessagePropertyExpressions()
	{
		return messagePropertyExpressions;
	}

	@Override
	public String getName()
	{
		return getBaseName();
	}
}
