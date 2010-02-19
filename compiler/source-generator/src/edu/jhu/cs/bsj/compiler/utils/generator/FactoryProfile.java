package edu.jhu.cs.bsj.compiler.utils.generator;

/**
 * Represents a profile for describing a factory.
 * @author Zachary Palmer
 */
public class FactoryProfile
{
	/** The interface name of the factory. */
	private String interfaceName;
	/** The class name of the factory. */
	private String className;
	/** The decorator class name. */
	private String decoratorClassName;
	
	/**
	 * Creates a factory profile.
	 * @param interfaceName The interface name of the factory.
	 * @param className The class name of the factory.
	 * @param decoratorClassName The decorator class name.
	 */
	public FactoryProfile(String interfaceName, String className, String decoratorClassName)
	{
		super();
		this.interfaceName = interfaceName;
		this.className = className;
		this.decoratorClassName = decoratorClassName;
	}

	public String getInterfaceName()
	{
		return interfaceName;
	}

	public String getClassName()
	{
		return className;
	}

	public String getDecoratorClassName()
	{
		return decoratorClassName;
	}
}
