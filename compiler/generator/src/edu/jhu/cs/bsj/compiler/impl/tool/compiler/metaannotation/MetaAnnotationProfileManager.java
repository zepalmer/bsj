package edu.jhu.cs.bsj.compiler.impl.tool.compiler.metaannotation;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.tools.DiagnosticListener;
import javax.tools.Diagnostic.Kind;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationMethodNameErrorType;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationMethodType;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.CountingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.IncorrectlyStaticMetaAnnotationMethodDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.InvalidMetaAnnotationMethodNameDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.InvalidMetaAnnotationMethodParameterCountDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.InvalidMetaAnnotationMethodReturnTypeDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaAnnotationPropertyMissingMethodDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaAnnotationPropertyTypeMismatchDiagnosticImpl;
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
	 * @param listener The listener to which errors will be reported.
	 * @param location The location at which any errors should be logged.
	 * @return A profile for the meta-annotation represented by that class.
	 */
	public MetaAnnotationProfile getProfile(Class<? extends BsjMetaAnnotation> clazz,
			DiagnosticListener<BsjSourceLocation> listener, BsjSourceLocation location)
	{
		MetaAnnotationProfile profile = this.profileMap.get(clazz);
		if (profile == null)
		{
			CountingDiagnosticProxyListener<BsjSourceLocation> proxy = new CountingDiagnosticProxyListener<BsjSourceLocation>(
					listener);
			profile = buildProfile(clazz, proxy, location);
			if (proxy.getCount(Kind.ERROR) > 0)
			{
				return null;
			}
			this.profileMap.put(clazz, profile);
		}
		return profile;
	}

	/**
	 * Creates a profile for the specified meta-annotation class.
	 * 
	 * @param clazz The meta-annotation class.
	 * @param listener The listener to which errors will be reported.
	 * @param location The location at which any errors should be logged.
	 * @return The profile for that class.
	 * @throws IllegalArgumentException If the provided class is unsuitable.
	 */
	// TODO: something more informative and sensible than IllegalArgumentException
	private MetaAnnotationProfile buildProfile(Class<? extends BsjMetaAnnotation> clazz,
			DiagnosticListener<BsjSourceLocation> listener, BsjSourceLocation location)
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
				processMethod(m, getterMethods, "get", MetaAnnotationMethodType.GETTER, 0, false, location, listener);
			}

			// If the method has a setter annotation...
			if (m.getAnnotation(BsjMetaAnnotationElementSetter.class) != null)
			{
				processMethod(m, setterMethods, "set", MetaAnnotationMethodType.SETTER, 1, true, location, listener);
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
				listener.report(new MetaAnnotationPropertyMissingMethodDiagnosticImpl(location, property,
						MetaAnnotationMethodType.GETTER));
				continue;
			}
			// Validate that setter exists
			if (setter == null)
			{
				listener.report(new MetaAnnotationPropertyMissingMethodDiagnosticImpl(location, property,
						MetaAnnotationMethodType.SETTER));
				continue;
			}
			// Validate that the getter's return type is assignable from the setter's parameter
			if (!getter.getReturnType().isAssignableFrom(setter.getParameterTypes()[0]))
			{
				listener.report(new MetaAnnotationPropertyTypeMismatchDiagnosticImpl(location, property));
				continue;
			}
		}

		// Everything looks good
		return new MetaAnnotationProfile(clazz, setterMethods);
	}

	/**
	 * Processes a method for profile building.
	 * 
	 * @param method The method in question.
	 * @param map The mapping to which to add the method upon success.
	 * @param string The name of the expected prefix for this method.
	 * @param type The type of method being produced.
	 * @param args The number of expected arguments.
	 * @param returnsVoid <code>true</code> if the method should return void; <code>false</code> if it should not.
	 * @param location The location to use when reporting errors.
	 * @param listener The listener to which to report errors.
	 */
	private void processMethod(Method method, Map<String, Method> map, String prefix, MetaAnnotationMethodType type,
			int args, boolean returnsVoid, BsjSourceLocation location, DiagnosticListener<BsjSourceLocation> listener)
	{
		// Validate name
		if (method.getName().length() < 4)
		{
			listener.report(new InvalidMetaAnnotationMethodNameDiagnosticImpl(location, type, method.getName(),
					MetaAnnotationMethodNameErrorType.TOO_SHORT));
			return;
		}
		if (!method.getName().startsWith(prefix))
		{
			listener.report(new InvalidMetaAnnotationMethodNameDiagnosticImpl(location, type, method.getName(),
					MetaAnnotationMethodNameErrorType.WRONG_PREFIX));
			return;
		}
		if (!Character.isUpperCase(method.getName().charAt(3)))
		{
			listener.report(new InvalidMetaAnnotationMethodNameDiagnosticImpl(location, type, method.getName(),
					MetaAnnotationMethodNameErrorType.BAD_FOURTH_CHARACTER));
			return;
		}
		// Validate return type
		if (method.getReturnType().equals(void.class) != returnsVoid)
		{
			listener.report(new InvalidMetaAnnotationMethodReturnTypeDiagnosticImpl(location, type, method.getName()));
			return;
		}
		// Validate parameter count
		if (method.getParameterTypes().length != args)
		{
			listener.report(new InvalidMetaAnnotationMethodParameterCountDiagnosticImpl(location, type,
					method.getName(), 0, method.getParameterTypes().length));
			return;
		}
		// Validate non-static
		if ((method.getModifiers() & Modifier.STATIC) != 0)
		{
			listener.report(new IncorrectlyStaticMetaAnnotationMethodDiagnosticImpl(location, type, method.getName()));
			return;
		}
		// Pass!
		map.put(Character.toLowerCase(method.getName().charAt(3)) + method.getName().substring(4), method);
	}
}
