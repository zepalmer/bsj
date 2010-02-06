package edu.jhu.cs.bsj.compiler.utils.generator;

/**
 * Represents information about a specific property in a factory method definition.
 * 
 * @author Zachary Palmer
 */
public class FactoryMethodPropertyDefinition
{
	/** The name of the property. */
	private String name;
	/**
	 * The visibility of the property. <code>true</code> indicates that the user must supply a value; <code>false</code>
	 * indicates that the value is provided automatically.
	 */
	private boolean visible;

	public FactoryMethodPropertyDefinition(String name, boolean visible)
	{
		super();
		this.name = name;
		this.visible = visible;
	}

	public String getName()
	{
		return name;
	}

	public boolean isVisible()
	{
		return visible;
	}

}
