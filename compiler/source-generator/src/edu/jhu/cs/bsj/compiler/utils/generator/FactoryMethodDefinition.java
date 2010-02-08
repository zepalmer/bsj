package edu.jhu.cs.bsj.compiler.utils.generator;

public interface FactoryMethodDefinition
{

	/**
	 * Determines if the property of the specified name is visible.
	 * @param name The name of the property.
	 * @return <code>true</code> if the property is visible; <code>false</code> otherwise.
	 */
	public boolean isVisible(String name);

	/**
	 * Notifies this factory method definition of its parent.  This may be important for some factory method definition
	 * classes.
	 * @param typeDefinition The type definition that this factory method definition is serving.
	 */
	public void setParent(TypeDefinition typeDefinition);

}