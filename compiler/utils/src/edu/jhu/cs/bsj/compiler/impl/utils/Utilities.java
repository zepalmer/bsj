package edu.jhu.cs.bsj.compiler.impl.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * A class for (very) general utility functions.
 * @author Zachary Palmer
 */
public class Utilities
{
	/**
	 * Retrieves an enum from the given array with the specified name.
	 * @param a The array of enums.
	 * @param n The name.
	 * @return The named enum or <code>null</code> if no such enum exists.
	 */
	public static <T extends Enum<T>> T getEnumByName(T[] a, String name)
	{
		for (T t : a)
		{
			if (t.name().equals(name))
			{
				return t;
			}
		}
		return null;
	}
	
	/**
	 * Retrieves a resource in Java properties file format from the classpath.
	 * @param path The name of the resource.
	 * @return The resulting {@link Properties} object or <code>null</code> if the resource could not be accessed.
	 */
	public static Properties loadProperties(String path)
	{
		try
		{
			InputStream is = Utilities.class.getResourceAsStream(path);
			Properties p = new Properties();
			p.load(is);
			is.close();
			return p;
		} catch (IOException e)
		{
			return null;
		}
	}
}
