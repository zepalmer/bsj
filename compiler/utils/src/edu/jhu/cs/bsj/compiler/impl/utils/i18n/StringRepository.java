package edu.jhu.cs.bsj.compiler.impl.utils.i18n;

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
}
