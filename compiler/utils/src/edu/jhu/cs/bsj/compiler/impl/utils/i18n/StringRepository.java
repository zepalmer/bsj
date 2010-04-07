package edu.jhu.cs.bsj.compiler.impl.utils.i18n;

import java.util.List;
import java.util.Locale;

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
	 * Retrieves a string in the message repository and uses it as a format string for the given arguments.  If the
	 * specified string cannot be found, a human-readable error string containing the arguments is returned.
	 * @param locale The locale to use or <code>null</code> for the default locale.
	 * @param key The key to use.
	 * @param args The arguments to provide to the formatter string.
	 * @return The resulting string.
	 */
	public String getFormattedMessage(Locale locale, String key, List<Object> args);
}
