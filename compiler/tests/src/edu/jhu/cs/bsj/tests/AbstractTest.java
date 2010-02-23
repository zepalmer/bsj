package edu.jhu.cs.bsj.tests;

import java.io.File;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

/**
 * This abstract test superclass contains convenience mechanisms for tests.
 * 
 * @author Zachary Palmer
 */
public abstract class AbstractTest
{
	/** The directory containing the example sources. */
	public static final File EXAMPLES = new File("examples");
	
	/**
	 * Configures Log4J using the specified information.
	 * 
	 * @param level The default level for logging messages.
	 * @param loggerSpecifics An array of "logger specifics" strings. Such a string contains exactly one slash and is a
	 *            terse way of configuring the logger to modify how logging messages from a certain package and its
	 *            subpackages are logged. For instance, "edu.jhu.cs.bsj.compiler.tool.parser.antlr/debug" will set the
	 *            BSJ ANTLR parser's logger in debug mode.
	 */
	protected static void log4jConfigure(String level, String... loggerSpecifics)
	{
		Properties loggingProperties = new Properties();
		loggingProperties.setProperty("log4j.rootLogger", level + ", stdout");
		loggingProperties.setProperty("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
		loggingProperties.setProperty("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
		loggingProperties.setProperty("log4j.appender.stdout.layout.ConversionPattern", "%5p [%t] (%F:%L) - %m%n");
		for (String loggerSpecific : loggerSpecifics)
		{
			String[] s = loggerSpecific.split("/");
			String logger = s[0];
			String llevel = s[1];
			loggingProperties.setProperty("log4j.logger." + logger, llevel + ", stdout");
			loggingProperties.setProperty("log4j.additivity.logger." + logger, "false");
		}
		PropertyConfigurator.configure(loggingProperties);
	}
}
