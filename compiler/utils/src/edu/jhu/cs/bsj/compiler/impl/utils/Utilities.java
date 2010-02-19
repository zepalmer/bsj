package edu.jhu.cs.bsj.compiler.impl.utils;

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
}
