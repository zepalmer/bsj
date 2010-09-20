package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.List;
import java.util.Map;

public interface IParameterizedPropertyBasedHierarchyDefinition<T extends PropertyBasedHierarchyDefinition<T, U>, U extends AbstractPropertyDefinition<U>>
	extends HierarchyDefinition<T>
{

	public String getBaseName();

	public String getTypeParameter();
	
	public String getUnboundedTypeParameter();

	public String getTypeParameterUpperBound();

	public String getBaseSuperName();

	public String getSuperTypeArg();

	public String getSuperName();

	public T getParent();

	public List<TagReferenceDefinition> getTags();

	public Map<String, String> getTypeArgMap();
}