package edu.jhu.cs.bsj.compiler.impl.utils.i18n;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * This interface represents a string repository which can be used to obtain Locale-specific strings.
 * 
 * @author Zachary Palmer
 */
public interface StringRepository
{
	/**
	 * Retrieves a string by locale and key.
	 * 
	 * @param locale The locale for which the string is necessary. If <code>null</code>, then the default locale is
	 *            used.
	 * @param key The string which identifies the string to return from this locale. (This identity is
	 *            locale-inspecific.)
	 * @return The string for that locale. If the locale is unsupported or the key was not found, <code>null</code> is
	 *         returned.
	 */
	public String lookup(Locale locale, String key);

	/**
	 * Retrieves a string in the message repository and uses it as a format string for the given arguments. If the
	 * specified string cannot be found, a human-readable error string containing the arguments is returned.
	 * 
	 * @param locale The locale to use or <code>null</code> for the default locale.
	 * @param key The key to use.
	 * @param args The arguments to provide to the formatter string.
	 * @return The resulting string.
	 */
	public String getFormattedMessage(Locale locale, String key, List<Object> args);

	/**
	 * Retrieves a string in the message repository and uses it as a format string for the given arguments. If the
	 * specified string cannot be found, a human-readable error string containing the arguments is returned.
	 * 
	 * @param locale The locale to use or <code>null</code> for the default locale.
	 * @param key The key to use.
	 * @param args The arguments to provide to the formatter string.
	 * @param argmap An optional mapping from names to indices. This allows strings of the form %{name} to be replaced
	 *            by strings of the form %n in the message string before it is used as a formatter string.  If
	 *            <code>null</code>, no replacement is performed.
	 * @return The resulting string.
	 */
	public String getFormattedMessage(Locale locale, String key, List<Object> args, Map<String, Integer> argmap);
}
