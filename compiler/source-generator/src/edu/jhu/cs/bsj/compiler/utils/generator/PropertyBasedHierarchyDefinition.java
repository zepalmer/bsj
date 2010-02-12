package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.ArrayList;
import java.util.List;

public abstract class PropertyBasedHierarchyDefinition<T extends PropertyBasedHierarchyDefinition<T>> implements
		HierarchyDefinition<T>
{
	/**
	 * Retrieves the properties for this definition as well as all of its parent definitions.  Assumes parent definitions
	 * should follow child definitions (instead of preceeding them).
	 */
	public List<PropertyDefinition> getRecursiveProperties()
	{
		return getRecursiveProperties(false);
	}
	
	/**
	 * Retrieves the properties for this definition as well as all of its parent definitions.
	 * @param parentFirst <code>true</code> if parent definitions should appear before child definitions in this list;
	 * <code>false</code> otherwise.
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
				props.addAll(0, def.getProperties());
			} else
			{
				props.addAll(def.getProperties());
			}
			def = def.getParent();
		}
		return props;
	}

	public abstract List<PropertyDefinition> getProperties();
}
