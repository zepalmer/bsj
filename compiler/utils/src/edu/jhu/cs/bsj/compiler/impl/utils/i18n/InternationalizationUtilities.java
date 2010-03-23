package edu.jhu.cs.bsj.compiler.impl.utils.i18n;

/**
 * This class provides utilities for internationalization.
 * @author Zachary Palmer
 */
public class InternationalizationUtilities
{
	/** The repository used for looking up BSJ compiler messages. */
	public static final StringRepository MESSAGE_REPOSITORY = new PropertyBasedStringRepository("/resources/messages/");
}
