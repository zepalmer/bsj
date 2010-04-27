package edu.jhu.cs.bsj.compiler.impl.diagnostic;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class containing static diagnostic utilities.
 * @author Zachary Palmer
 */
public class DiagnosticUtilities
{
	/** The regexp pattern used to match names of the form %{name}. */
	private static final Pattern NAME_PATTERN = Pattern.compile("%\\{[^}]+?\\}");
	
	/**
	 * Prevent instantiation of utilities class.
	 */
	private DiagnosticUtilities()
	{
	}
	
	/**
	 * Converts the provided message into a format string.  This is done by converting symbols of the form
	 * "%{name}" into symbols of the form %n by looking up name-&gt;n mappings in the provided map.
	 * @param string The original message string.
	 * @param map The mapping from names to indices.
	 * @return The resulting format string.
	 */
	public static String convertMessageToFormatString(String string, Map<String,Integer> map)
	{
		Matcher m = NAME_PATTERN.matcher(string);
		int index = 0;
		while (m.find(index))
		{
			String name = string.substring(m.start()+2,m.end()-1);
			Integer id = map.get(name);
			if (id == null)
			{
				index = m.end();
			}
			string = string.substring(0, m.start()) + "%" + id + string.substring(m.end());
			m = NAME_PATTERN.matcher(string);
		}
		return string;
	}
}
