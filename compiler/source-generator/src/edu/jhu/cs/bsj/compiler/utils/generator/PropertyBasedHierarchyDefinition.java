package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class PropertyBasedHierarchyDefinition<T extends PropertyBasedHierarchyDefinition<T,U>, U extends AbstractPropertyDefinition<U>> implements
		HierarchyDefinition<T>
{
	/**
	 * Retrieves the properties for this definition as well as all of its parent definitions. Assumes parent definitions
	 * should follow child definitions (instead of preceeding them).
	 */
	public List<U> getRecursiveProperties()
	{
		return getRecursiveProperties(false);
	}

	/**
	 * Retrieves the properties for which this definition is responsible. This is the union of the set of declared
	 * properties on this definition and the set of properties declared on all of this definition's tags.
	 * 
	 * @return The list of property definitions.
	 */
	public List<U> getResponsibleProperties(boolean parentFirst)
	{
		List<U> props = new ArrayList<U>();
		if (parentFirst)
		{
			for (TagReferenceDefinition tag : this.getTags())
			{
				PropertyBasedHierarchyDefinition<T,U> tagDef = this.getNamespaceMap().get(tag.getName());
				props.addAll(0, tagDef.getResponsibleProperties(parentFirst));
			}
			props.addAll(0, this.getProperties());
		} else
		{
			props.addAll(this.getProperties());
			for (TagReferenceDefinition tag : this.getTags())
			{
				PropertyBasedHierarchyDefinition<T,U> tagDef = this.getNamespaceMap().get(tag.getName());
				props.addAll(tagDef.getResponsibleProperties(parentFirst));
			}
		}
		eliminateDuplicates(props, parentFirst);
		return props;
	}

	/**
	 * Eliminates duplicates from the provided properties list.
	 * 
	 * @param list The list to filter.
	 * @param parentFirst <code>true</code> if the list is sorted with parent properties first; <code>false</code>
	 *            otherwise.
	 */
	protected void eliminateDuplicates(List<U> list, boolean parentFirst)
	{
		// Eliminate duplicates
		Set<String> propertyNames = new HashSet<String>();
		if (parentFirst)
		{
			Collections.reverse(list);
			Iterator<U> iterator = list.iterator();
			while (iterator.hasNext())
			{
				if (!propertyNames.add(iterator.next().getName()))
					iterator.remove();
			}
			Collections.reverse(list);
		} else
		{
			Iterator<U> iterator = list.iterator();
			while (iterator.hasNext())
			{
				if (!propertyNames.add(iterator.next().getName()))
					iterator.remove();
			}
		}
	}

	/**
	 * Retrieves the properties for this definition as well as all of its parent definitions.
	 * 
	 * @param parentFirst <code>true</code> if parent definitions should appear before child definitions in this list;
	 *            <code>false</code> otherwise.
	 * @return The list of property definitions.
	 */
	public List<U> getRecursiveProperties(boolean parentFirst)
	{
		List<U> props = new ArrayList<U>();
		PropertyBasedHierarchyDefinition<T,U> def = this;
		while (def != null)
		{
			if (parentFirst)
			{
				props.addAll(0, def.getResponsibleProperties(parentFirst));
			} else
			{
				props.addAll(def.getResponsibleProperties(parentFirst));
			}
			def = def.getParent();
		}

		eliminateDuplicates(props, parentFirst);
		return props;
	}

	public abstract List<U> getProperties();
}
