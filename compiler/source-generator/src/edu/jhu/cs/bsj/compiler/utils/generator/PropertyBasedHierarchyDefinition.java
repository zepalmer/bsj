package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class PropertyBasedHierarchyDefinition<T extends PropertyBasedHierarchyDefinition<T>> implements
		HierarchyDefinition<T>
{
	/**
	 * Retrieves the properties for this definition as well as all of its parent definitions. Assumes parent definitions
	 * should follow child definitions (instead of preceeding them).
	 */
	public List<PropertyDefinition> getRecursiveProperties()
	{
		return getRecursiveProperties(false);
	}

	/**
	 * Retrieves the properties for this definition as well as all of its parent definitions.
	 * 
	 * @param parentFirst <code>true</code> if parent definitions should appear before child definitions in this list;
	 *            <code>false</code> otherwise.
	 * @return The list of property definitions.
	 */
	public List<PropertyDefinition> getRecursiveProperties(boolean parentFirst)
	{
		List<PropertyDefinition> props = new ArrayList<PropertyDefinition>();
		PropertyBasedHierarchyDefinition<T> def = this;
		while (def != null)
		{
			if (parentFirst)
			{
				for (String tagName : def.getTags())
				{
					PropertyBasedHierarchyDefinition<T> tagDef = def.getNamespaceMap().get(tagName);
					props.addAll(0, tagDef.getProperties());
				}
				props.addAll(0, def.getProperties());
				Set<String> propertyNames = new HashSet<String>();
				Collections.reverse(props);
				Iterator<PropertyDefinition> iterator = props.iterator();
				while (iterator.hasNext())
				{
					if (!propertyNames.add(iterator.next().getName()))
						iterator.remove();
				}
				Collections.reverse(props);
			} else
			{
				props.addAll(def.getProperties());
				for (String tagName : def.getTags())
				{
					PropertyBasedHierarchyDefinition<T> tagDef = def.getNamespaceMap().get(tagName);
					props.addAll(tagDef.getProperties());
				}
				Set<String> propertyNames = new HashSet<String>();
				Iterator<PropertyDefinition> iterator = props.iterator();
				while (iterator.hasNext())
				{
					if (!propertyNames.add(iterator.next().getName()))
						iterator.remove();
				}
			}
			def = def.getParent();
		}
		return props;
	}

	public abstract List<PropertyDefinition> getProperties();
}
