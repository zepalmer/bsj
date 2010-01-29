package edu.jhu.cs.bsj.compiler.impl.utils;

/**
 * Contains utilities related to string manipulation.
 * @author Zachary Palmer
 */
public class StringUtilities
{
	/**
	 * Prevents instantiation.
	 */
	private StringUtilities()
	{
	}
	
	/**
	 * Removes all characters from the provided string including and after the last instance of the specified
	 * character.  If that character does not exist in the provided string, it is returned as it is.
	 * @param string The source string.
	 * @param ch The character to use as the stripping point.
	 * @return The resulting string.
	 */
	public static String removeSuffix(String string, char ch)
	{
		int index = string.lastIndexOf(ch);
		if (index==-1)
		{
			return string;
		} else
		{
			return string.substring(0, index);
		}
	}
}
