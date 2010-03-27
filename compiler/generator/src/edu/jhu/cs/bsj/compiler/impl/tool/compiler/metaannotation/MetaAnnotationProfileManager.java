package edu.jhu.cs.bsj.compiler.impl.tool.compiler.metaannotation;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;

/**
 * Contains profiles for meta-annotation declarations visible in the current metaprogram classpath.
 * 
 * @author Zachary Palmer
 */
public class MetaAnnotationProfileManager
{
	/**
	 * A cache from meta-annotation classes to meta-annotation profiles.
	 */
	private Map<Class<? extends BsjMetaAnnotation>, MetaAnnotationProfile> profileMap;

	/**
	 * Creates a new profile manager for meta-annotations.
	 */
	public MetaAnnotationProfileManager()
	{
		this.profileMap = new HashMap<Class<? extends BsjMetaAnnotation>, MetaAnnotationProfile>();
	}

	/**
	 * Retrieves a profile for a meta-annotation.
	 * 
	 * @param clazz The class for which a profile is desired.
	 * @return A profile for the meta-annotation represented by that class.
	 */
	public MetaAnnotationProfile getProfile(Class<? extends BsjMetaAnnotation> clazz)
	{
		MetaAnnotationProfile profile = this.profileMap.get(clazz);
		if (profile == null)
		{
			profile = buildProfile(clazz);
			this.profileMap.put(clazz, profile);
		}
		return profile;
	}

	/**
	 * Creates a profile for the specified meta-annotation class.
	 * 
	 * @param clazz The meta-annotation class.
	 * @return The profile for that class.
	 * @throws IllegalArgumentException If the provided class is unsuitable.
	 */
	// TODO: something more informative and sensible than IllegalArgumentException
	private MetaAnnotationProfile buildProfile(Class<? extends BsjMetaAnnotation> clazz)
	{
		// Validate that the class is not abstract
		if ((clazz.getModifiers() & Modifier.ABSTRACT) != 0)
		{
			throw new IllegalArgumentException("Attempted to build profile for abstract class " + clazz.getName());
		}
		
		// Process getters and setters
		Map<String, Method> getterMethods = new HashMap<String, Method>();
		Map<String, Method> setterMethods = new HashMap<String, Method>();

		for (Method m : clazz.getDeclaredMethods())
		{
			// If the method has a getter annotation...
			if (m.getAnnotation(BsjMetaAnnotationElementGetter.class) != null)
			{
				// Validate getter name
				if (m.getName().length() < 4)
				{
					throw new IllegalArgumentException("Invalid getter name " + m.getName() + ": too short");
				}
				if (!m.getName().startsWith("get"))
				{
					throw new IllegalArgumentException("Invalid getter name " + m.getName()
							+ ": does not start with \"get\"");
				}
				if (!Character.isUpperCase(m.getName().charAt(3)))
				{
					throw new IllegalArgumentException("Invalid getter name " + m.getName()
							+ ": fourth character is not upper-case");
				}
				// Validate return type
				if (m.getReturnType().equals(void.class))
				{
					throw new IllegalArgumentException("Getter named " + m.getName() + " has void return type");
				}
				// Validate lack of parameters
				if (m.getParameterTypes().length > 0)
				{
					throw new IllegalArgumentException("Getter named " + m.getName() + " has non-empty parameter list");
				}
				// Validate non-static
				if ((m.getModifiers() & Modifier.STATIC) != 0)
				{
					throw new IllegalArgumentException("Getter named " + m.getName() + " is declared static");
				}
				// Pass!
				getterMethods.put(Character.toLowerCase(m.getName().charAt(3)) + m.getName().substring(4), m);
			}

			// If the method has a setter annotation...
			if (m.getAnnotation(BsjMetaAnnotationElementSetter.class) != null)
			{
				// Validate setter name
				if (m.getName().length() < 4)
				{
					throw new IllegalArgumentException("Invalid setter name " + m.getName() + ": too short");
				}
				if (!m.getName().startsWith("set"))
				{
					throw new IllegalArgumentException("Invalid setter name " + m.getName()
							+ ": does not start with \"set\"");
				}
				if (!Character.isUpperCase(m.getName().charAt(3)))
				{
					throw new IllegalArgumentException("Invalid setter name " + m.getName()
							+ ": fourth character is not upper-case");
				}
				// Validate return type
				if (!m.getReturnType().equals(void.class))
				{
					throw new IllegalArgumentException("Setter named " + m.getName() + " has non-void return type");
				}
				// Validate lack of parameters
				if (m.getParameterTypes().length != 1)
				{
					throw new IllegalArgumentException("Setter named " + m.getName() + " must have single parameter");
				}
				// Validate non-static
				if ((m.getModifiers() & Modifier.STATIC) != 0)
				{
					throw new IllegalArgumentException("Setter named " + m.getName() + " is declared static");
				}
				// Pass!
				setterMethods.put(Character.toLowerCase(m.getName().charAt(3)) + m.getName().substring(4), m);
			}
		}

		// Now validate the pairings
		Set<String> properties = new HashSet<String>();
		properties.addAll(getterMethods.keySet());
		properties.addAll(setterMethods.keySet());
		for (String property : properties)
		{
			Method getter = getterMethods.get(property);
			Method setter = setterMethods.get(property);
			// Validate that getter exists
			if (getter == null)
			{
				throw new IllegalArgumentException("Property " + property + " has no getter");
			}
			// Validate that setter exists
			if (setter == null)
			{
				throw new IllegalArgumentException("Property " + property + " has no setter");
			}
			// Validate that the getter's return type is assignable from the setter's parameter
			if (!getter.getReturnType().isAssignableFrom(setter.getParameterTypes()[0]))
			{
				throw new IllegalArgumentException("Property " + property
						+ " setter has an argument that isn't assignable to getter's return type.");
			}
		}
		
		// Everything looks good
		return new MetaAnnotationProfile(clazz, setterMethods);
	}
}
