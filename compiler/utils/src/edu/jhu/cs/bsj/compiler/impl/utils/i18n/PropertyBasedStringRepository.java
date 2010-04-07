package edu.jhu.cs.bsj.compiler.impl.utils.i18n;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/**
 * This {@link StringRepository} retrieves strings from a resource file on the classpath of this repository's
 * classloader at runtime. The strings are expected to be stored in properties file in a given directory in the
 * classpath (which is specified at construction). Each properties file is named "xxx.properties" where "xxx" is the ISO
 * 639-2 code for the language of the locale in question.  If such a properties file does not exist, the Locale is not
 * supported by this repository.
 * 
 * @author Zachary Palmer
 */
public class PropertyBasedStringRepository implements StringRepository
{
	/** The base path for the resources. */
	private String basePath;
	/** A mapping between ISO 639-2 codes and the loaded {@link Properties} objects. */
	private Map<String,Properties> propertiesCache;
	
	/**
	 * Creates a string repository using the specified base path.
	 * @param basePath The base path of the repository's files.
	 */
	public PropertyBasedStringRepository(String basePath)
	{
		super();
		this.basePath = basePath;
		this.propertiesCache = new HashMap<String, Properties>();
	}
	
	/**
	 * Loads the properties for the specified language code.
	 * @param code The ISO 639-2 language code.
	 * @return The {@link Properties} for that language code or <code>null</code> if no file could be found.
	 */
	private Properties load(String code)
	{
		try
		{
			String path = basePath + '/' + code + ".properties";
			InputStream is = getClass().getResourceAsStream(path);
			Properties p = new Properties();
			p.load(is);
			is.close();
			return p;
		} catch (IOException e)
		{
			return null;
		}
	}

	@Override
	public String lookup(Locale locale, String key)
	{
		if (locale==null)
		{
			locale = Locale.getDefault();
		}
		String code = locale.getISO3Language();
		Properties p = propertiesCache.get(code);
		if (p==null)
		{
			p = load(code);
			if (p == null)
			{
				return null;
			}
			propertiesCache.put(code, p);
		}
		
		return p.getProperty(key);
	}

	@Override
	public String getFormattedMessage(Locale locale, String key, List<Object> args)
	{
		String formatString = InternationalizationUtilities.MESSAGE_REPOSITORY.lookup(locale, key);
		if (formatString == null)
		{
			// try to produce a default message in English with a warning
			formatString = InternationalizationUtilities.MESSAGE_REPOSITORY.lookup(Locale.US, key);
			if (formatString == null)
			{
				// no hope! no hope!
				StringBuilder sb = new StringBuilder("(could not get string for key " + key + "; [");
				boolean first = true;
				for (Object arg : args)
				{
					if (first)
					{
						first = false;
					} else
					{
						sb.append(',');
					}
					sb.append(arg);
				}
				sb.append("])");
				return sb.toString();
			}
			// 
			formatString = "(no strings found for language=" + locale.getDisplayLanguage() + ") " + formatString;
		}

		return String.format(locale, formatString, args.toArray());
	}
}
