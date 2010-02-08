package edu.jhu.cs.bsj.compiler.utils.generator;

/**
 * A factory method definition which uses the properties that do not have defaults.
 * 
 * @author Zachary Palmer
 */
public class UseDefaultsFactoryMethodDefinition implements FactoryMethodDefinition
{
	private TypeDefinition parent;

	@Override
	public boolean isVisible(String name)
	{
		// TODO: wrong properties definition - needs to be recursive
		for (PropertyDefinition def : this.parent.getRecursiveProperties())
		{
			if (def.getName().equals(name))
			{
				return def.getDefaultExpression() == null;
			}
		}
		throw new IllegalStateException("Asked for visibility of unrecognized property " + name);
	}

	@Override
	public void setParent(TypeDefinition typeDefinition)
	{
		this.parent = typeDefinition;
	}
}
