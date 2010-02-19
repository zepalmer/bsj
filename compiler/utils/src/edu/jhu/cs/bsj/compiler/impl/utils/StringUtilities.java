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
	
	/**
	 * Retrieves the suffix for the provided string after the last instance of the specified character (but not
	 * including it).  If that character does not exist in the provided string, it is returned as it is.
	 * @param string The string.
	 * @param ch The character to use to find the suffix.
	 * @return The suffix.
	 */
	public static String getSuffix(String string, char ch)
	{
		int index = string.lastIndexOf(ch);
		if (index==-1)
		{
			return string;
		} else
		{
			return string.substring(index + 1);
		}
	}
	
	/**
	 * Converts a Java camel-case identifier into an upper-case identifier.
	 * @param ident The identifier to convert.
	 * @return The resulting identifier.
	 */
	public static String convertCamelCaseToUpperCase(String ident)
	{
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<ident.length();i++)
		{
			if (i>0 && Character.isUpperCase(ident.charAt(i)))
			{
				sb.append("_");
			}
			sb.append(Character.toUpperCase(ident.charAt(i)));
		}
		return sb.toString();
	}
}
