package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.List;
import java.util.Map;

/**
 * Implemented by definitions which represent a type hierarchy.
 * @author Zachary Palmer
 *
 * @param <T> The type of value in the hierarchy.
 */
public interface HierarchyDefinition<T extends HierarchyDefinition<T>>
{
	public String getName();

	public String getSuperName();

	public T getParent();
	
	public void setParent(T parent);
	
	public Map<String,T> getNamespaceMap();
	
	public void setNamespaceMap(Map<String,T> map);
	
	public List<String> getTags();
}