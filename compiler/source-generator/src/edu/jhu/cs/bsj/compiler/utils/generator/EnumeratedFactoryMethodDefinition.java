package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.List;

/**
 * Defines a supplementary factory method.
 * @author Zachary Palmer
 */
public class EnumeratedFactoryMethodDefinition implements FactoryMethodDefinition
{
	/** The properties which are visible for this definition. */
	private List<FactoryMethodPropertyDefinition> properties;

	public EnumeratedFactoryMethodDefinition(List<FactoryMethodPropertyDefinition> properties)
	{
		super();
		this.properties = properties;
	}

	public List<FactoryMethodPropertyDefinition> getProperties()
	{
		return properties;
	}
	
	/**
	 * Determines if the property of the specified name is visible.
	 * @param name The name of the property.
	 * @return <code>true</code> if the property is visible; <code>false</code> otherwise.
	 */
	public boolean isVisible(String name)
	{
		for (FactoryMethodPropertyDefinition def : this.properties)
		{
			if (def.getName().equals(name))
			{
				return def.isVisible();
			}
		}
		return false;
	}

	@Override
	public void setParent(TypeDefinition typeDefinition)
	{
		// Ignored
	}
}
