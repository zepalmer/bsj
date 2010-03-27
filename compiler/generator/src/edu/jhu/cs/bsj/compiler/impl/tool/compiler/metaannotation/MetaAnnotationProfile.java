package edu.jhu.cs.bsj.compiler.impl.tool.compiler.metaannotation;

import java.lang.reflect.Method;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;

/**
 * Represents a profile for a meta-annotation class.
 * @author Zachary Palmer
 */
public class MetaAnnotationProfile
{
	/**
	 * The class represented by this profile.
	 */
	private Class<? extends BsjMetaAnnotation> clazz;
	/**
	 * A mapping from the names of the properties of the meta-annotation class to the setter methods for those properties.
	 */
	private Map<String,Method> setterMap;
	
	/**
	 * Creates a new meta-annotation profile.
	 */
	public MetaAnnotationProfile(Class<? extends BsjMetaAnnotation> clazz, Map<String,Method> setterMap)
	{
		this.clazz = clazz;
		this.setterMap = setterMap;
	}

	public Class<? extends BsjMetaAnnotation> getMetaAnnotationClass()
	{
		return clazz;
	}

	public Map<String, Method> getSetterMap()
	{
		return setterMap;
	}
	
	/**
	 * Obtains the type of the specified property.
	 * @param property The name of the property.
	 * @return The type of the property or <code>null</code> if that property does not exist.
	 */
	public Class<?> getPropertyType(String property)
	{
		Method m = this.setterMap.get(property);
		if (m==null)
		{
			return null;
		}
		return m.getParameterTypes()[0];
	}
}
