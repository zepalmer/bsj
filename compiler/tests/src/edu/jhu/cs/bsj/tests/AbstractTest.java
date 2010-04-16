package edu.jhu.cs.bsj.tests;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.RegularFileLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.UnionLocationManager;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkitFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManagerFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.LocationManager;

/**
 * This abstract test superclass contains convenience mechanisms for tests.
 * 
 * @author Zachary Palmer
 */
public abstract class AbstractTest
{
	/** The directory containing the example sources. */
	public static final File EXAMPLES = new File("resources" + File.separator + "source-code");
	/** The directory containing individual sources for specific tests. */
	public static final File SPECIFIC_SOURCE_DIR = new File(EXAMPLES + File.separator + "individual-files"
			+ File.separator + "hand-written");

	/** The logger for this class. */
	protected Logger LOGGER = null;
	{
		String s = System.getProperty("bsj.tests.logging");
		if (s == null || s.length() == 0)
		{
			log4jConfigure("trace", "edu.jhu.cs.bsj.compiler.impl.tool.filemanager/debug",
					"edu.jhu.cs.bsj.compiler.impl.tool.parser.antlr/debug",
					"edu.jhu.cs.bsj.compiler.impl.tool.compiler.names/debug");
		} else
		{
			String[] values = s.split("&");
			String level = values[0];
			values = Arrays.copyOfRange(values, 1, values.length);
			log4jConfigure(level, values);
		}
	}

	/**
	 * Configures Log4J using the specified information.
	 * 
	 * @param level The default level for logging messages.
	 * @param loggerSpecifics An array of "logger specifics" strings. Such a string contains exactly one slash and is a
	 *            terse way of configuring the logger to modify how logging messages from a certain package and its
	 *            subpackages are logged. For instance, "edu.jhu.cs.bsj.compiler.tool.parser.antlr/debug" will set the
	 *            BSJ ANTLR parser's logger in debug mode.
	 */
	protected void log4jConfigure(String level, String... loggerSpecifics)
	{
		LOGGER = Logger.getLogger(this.getClass());
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

	private static File getTestDir(String suffix)
	{
		return new File("." + File.separator + "local" + File.separator + suffix);
	}

	private static LocationManager getTestLocationManager(String suffix)
	{
		File dir = getTestDir(suffix);
		dir.mkdirs();
		return new RegularFileLocationManager(null, dir);
	}

	protected BsjFileManager getFileManager(File sourcePath) throws Exception
	{
		BsjFileManagerFactory fileManagerFactory = BsjServiceRegistry.newFileManagerFactory();

		Map<BsjCompilerLocation, LocationManager> map = new HashMap<BsjCompilerLocation, LocationManager>();

		File test = new File("." + File.separator + "local");
		test.mkdir();

		LocationManager sourceLocationManager;
		if (sourcePath == null)
		{
			sourceLocationManager = getTestLocationManager("src");
		} else
		{
			sourceLocationManager = new RegularFileLocationManager(null, sourcePath);
		}
		map.put(BsjCompilerLocation.SOURCE_PATH, sourceLocationManager);
		map.put(BsjCompilerLocation.GENERATED_SOURCE_PATH, getTestLocationManager("gensrc"));
		map.put(BsjCompilerLocation.CLASS_OUTPUT, getTestLocationManager("bin"));

		map.put(BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("sun.boot.class.path")));
		map.put(BsjCompilerLocation.METAPROGRAM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("java.class.path")));

		map.put(BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("sun.boot.class.path")));
		map.put(BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("java.class.path")));

		fileManagerFactory.setLocationManagerMappingsByManager(map);
		return fileManagerFactory.newFileManager();
	}

	protected BsjToolkit getToolkit(File sourcePath) throws Exception
	{
		BsjToolkitFactory bsjToolkitFactory = BsjServiceRegistry.newToolkitFactory();
		bsjToolkitFactory.setFileManager(getFileManager(sourcePath));
		return bsjToolkitFactory.newToolkit();
	}
}
