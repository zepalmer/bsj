package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a profile for describing how generation should proceed. Profiles effectively represent views of stacked
 * scoping layers in the XML file. For example, an outer srcgen nesting level might define properties "a" and "b" as
 * "A1" and "B1" and not define property "c" at all. An inner level may then define properties "b" and "c" as "B2" and
 * "C2", eliding the property "a". Elements within that space would likely receive a profile mapping "a" to "A1", "b" to
 * "B2", and "c" to "C2". </p> The meaning of each of the profile properties is different and specific to its particular
 * handler in the source generator.
 * 
 * @author Zachary Palmer
 */
public class GenerationProfile
{
	public static final Element<String> FACTORY_INTERFACE_NAME = new Element<String>();
	public static final Element<String> FACTORY_CLASS_NAME = new Element<String>();
	public static final Element<String> FACTORY_DECORATOR_CLASS_NAME = new Element<String>();
	public static final Element<String> GENERATED_INTERFACE_PACKAGE_NAME = new Element<String>();
	public static final Element<String> GENERATED_CLASS_PACKAGE_NAME = new Element<String>();

	public static final Element<TypeDefinition.Mode> DEFAULT_TYPE_MODE = new Element<TypeDefinition.Mode>(
			TypeDefinition.Mode.CONCRETE);
	public static final Element<PropertyDefinition.Mode> DEFAULT_PROPERTY_MODE = new Element<PropertyDefinition.Mode>(
			PropertyDefinition.Mode.NORMAL);
	public static final Element<Project> TARGET_PROJECT = new Element<Project>(Project.GENERATOR);

	public static final class Element<T>
	{
		private T defaultValue;

		private Element()
		{
			this(null);
		}

		private Element(T defaultValue)
		{
			this.defaultValue = defaultValue;
		}

		private T getDefaultValue()
		{
			return defaultValue;
		}
	}

	/** The properties of this profile. */
	private Map<Element<?>, Object> properties;

	public GenerationProfile()
	{
		super();
		this.properties = new HashMap<Element<?>, Object>();
	}

	/**
	 * Retrieves a property from this profile.
	 */
	@SuppressWarnings("unchecked")
	public <T> T getProperty(Element<T> e)
	{
		if (this.properties.containsKey(e))
		{
			return (T) this.properties.get(e);
		} else
		{
			return e.getDefaultValue();
		}
	}

	/**
	 * Derives another profile with the same properties as this profile except with the specified mapping.
	 * 
	 * @return The resulting profile.
	 */
	public <T> GenerationProfile derive(Element<T> e, T value)
	{
		GenerationProfile ret = new GenerationProfile();
		ret.properties.putAll(this.properties);
		ret.properties.put(e, value);
		return ret;
	}
}
