package edu.jhu.cs.bsj.compiler.impl.tool.bsjc;

import static edu.jhu.cs.bsj.compiler.impl.tool.bsjc.BsjcCmdLineArgs.ANNOTATION_PROCESSOR_PATH_ARG;
import static edu.jhu.cs.bsj.compiler.impl.tool.bsjc.BsjcCmdLineArgs.DEBUG_ARG;
import static edu.jhu.cs.bsj.compiler.impl.tool.bsjc.BsjcCmdLineArgs.DESTINATION_ARG;
import static edu.jhu.cs.bsj.compiler.impl.tool.bsjc.BsjcCmdLineArgs.GEN_SOURCEPATH_ARG;
import static edu.jhu.cs.bsj.compiler.impl.tool.bsjc.BsjcCmdLineArgs.HELP_ARG;
import static edu.jhu.cs.bsj.compiler.impl.tool.bsjc.BsjcCmdLineArgs.META_CLASSPATH_ARG;
import static edu.jhu.cs.bsj.compiler.impl.tool.bsjc.BsjcCmdLineArgs.OBJECT_CLASSPATH_ARG;
import static edu.jhu.cs.bsj.compiler.impl.tool.bsjc.BsjcCmdLineArgs.SOURCEPATH_ARG;
import static edu.jhu.cs.bsj.compiler.impl.tool.bsjc.BsjcCmdLineArgs.TRACE_ARG;
import static edu.jhu.cs.bsj.compiler.impl.tool.bsjc.BsjcCmdLineArgs.VERSION_ARG;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject.Kind;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.log4j.PropertyConfigurator;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.StandardBsjCompiler;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.RegularFileLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.UnionLocationManager;
import edu.jhu.cs.bsj.compiler.impl.utils.diagnostic.DiagnosticPrintingListener;
import edu.jhu.cs.bsj.compiler.tool.BsjCompiler;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkitFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManagerFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.tool.filemanager.LocationManager;

/**
 * This class functions as the BSJ version of javac.
 * 
 * @author Joseph Riley
 */
public class BsjC
{
	/**
	 * The bsjc version.
	 */
	public static final String VERSION = "0.1";
	
	/**
     * The bsj file extension.
     */
    public static final String BSJ_EXTENSION = ".bsj";
	
	/**
	 * A normal exit return code.
	 */
	public static final int NORMAL_EXIT = 0;
	
	/**
     * An erroneous exit return code.
     */
	public static final int ERROR_EXIT = 1;
	
	/**
	 * The {@link BsjFileManager} used for the filesystem abstraction.
	 */
	private BsjFileManager bsjFileManager;
	
	/**
	 * Diagnostic listener for compilation.
	 */
	private DiagnosticListener<BsjSourceLocation> listener;
	
	/**
	 * Objects to be compiled.
	 */
	private List<BsjFileObject> compileObjects;
	
	/**
	 * Constructor.
	 * Sets up default values.
	 */
	public BsjC()
	{
		listener = new DiagnosticPrintingListener<BsjSourceLocation>(System.err);
	}
	
	/**
	 * Perform compilation in the manner of javac's command-line usage.
	 * @param args command-line arguments for compilation.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args)
	{
		// parse the command line arguments
		CommandLineParser parser = new PosixParser();
		Options options = BsjC.initOptions();
		CommandLine cmd = null;
		try
		{
			cmd = parser.parse(options, args);
		} catch (ParseException e)
		{
			System.out.println("Invalid command line arguments: " + e.getMessage());
			System.exit(ERROR_EXIT);
		}
		
		// display help page and exit if requested or if no args are supplied
		if (args.length == 0 || cmd.hasOption(HELP_ARG))
		{
		    HelpFormatter formatter = new HelpFormatter();
		    formatter.printHelp("bsjc", options);
		    System.exit(NORMAL_EXIT);
		}
		
		// display version info and exit if requested
		if (cmd.hasOption(VERSION_ARG))
		{
			System.out.println("bsjc " + VERSION);
			System.exit(NORMAL_EXIT);
		}
		
		// build the file manager using the supplied arguments
		BsjFileManager bfm = null;
        try
        {
            bfm = createFileManagerFromArgs(cmd);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + e.getMessage());
            System.exit(ERROR_EXIT);
        }
        catch (IOException e)
        {
            System.out.println("Specified pathname does not exist: " + e.getMessage());
            System.exit(ERROR_EXIT);
        }
		
		// get files for compilation, any left over arguments are source files
		List<BsjFileObject> sourceFiles = new ArrayList<BsjFileObject>();		
		for (String sourceFile : cmd.getArgs())
		{
            try
            {
                // check for valid file extension ('.java' or '.bsj')
                if (!(sourceFile.endsWith(Kind.SOURCE.extension) 
                        || sourceFile.endsWith(BSJ_EXTENSION)))
                {
                    throw new IOException("Invalid file extension");
                }
                
                // extract package and relative name from full sourcefile name
                // TODO: pull off sourcepath prefix first
                int separatorIndex = sourceFile.lastIndexOf(File.separator);
                String packageName = separatorIndex == -1 ? "" : sourceFile.substring(0, separatorIndex);
                String relativeName = sourceFile.substring(separatorIndex + 1);

                // add to our sourcefile list using our file manager
                sourceFiles.add(bfm.getFileForInput(
                        BsjCompilerLocation.SOURCE_PATH, 
                        packageName, 
                        relativeName));
            }
            catch (IOException e)
            {
                System.out.println("Error on source file \"" + sourceFile + "\": " + e.getMessage());
                System.exit(ERROR_EXIT);
            }
		}
		
		// set the logging level to use for the StandardBsjCompiler, trace overrides debug
		String loggingLevel = "info";
		if (cmd.hasOption(TRACE_ARG))
		{
		    loggingLevel = "trace";
		}
		else if (cmd.hasOption(DEBUG_ARG))
		{
		    loggingLevel = "debug";
		}
		
		// compile the source files using the file manager
		BsjC bsjc = new BsjC();
		bsjc.configureLog4j(loggingLevel);
		bsjc.setBsjFileManager(bfm);
		bsjc.setCompileObjects(sourceFiles);
		try
        {
            bsjc.compile();
        }
        catch (IOException e)
        {
            System.out.println("Error during compilation: " + e.getMessage());
            System.exit(ERROR_EXIT);
        }
	}
	
	/**
	 * Configure the log4j properties.
	 * @param level the desired logging level to display.
	 */
	public void configureLog4j(String level)
    {
        Properties loggingProperties = new Properties();
        loggingProperties.setProperty("log4j.rootLogger", level + ", stdout");
        loggingProperties.setProperty("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
        loggingProperties.setProperty("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
        loggingProperties.setProperty("log4j.appender.stdout.layout.ConversionPattern", "%5p [%t] (%F:%L) - %m%n");
        loggingProperties.setProperty("log4j.logger." + StandardBsjCompiler.class, level + ", stdout");
        loggingProperties.setProperty("log4j.additivity.logger." + StandardBsjCompiler.class, "false");

        PropertyConfigurator.configure(loggingProperties);
    }

    /**
	 * Takes a parsed set of command line arguments and uses them to
	 * create a location mapped file manager.
	 * @param cmd the parsed set of command line arguments.
	 * @return a location mapped file manager.
	 * @throws FileNotFoundException If canonicalization of a pathname fails.
	 * @throws IOException If one of the specified pathnames does not exist.
	 */
	public static BsjFileManager createFileManagerFromArgs(CommandLine cmd) 
		throws FileNotFoundException, IOException 
	{
		// map the locations for the file manager
		Map<BsjCompilerLocation, LocationManager> map = 
		    new HashMap<BsjCompilerLocation, LocationManager>();
		
		// set the default values for the locations
		File sourcePath = new File(".");
		File classOutput = new File(".");
		File bsjSourcePath = new File("." + File.separator + "bsjgensrc");
		String metaProgramClasspath = System.getProperty("java.class.path");
		String objectProgramClasspath = System.getProperty("java.class.path");
		String annotationProcessorPath = objectProgramClasspath;
		
		// set the sourcepath
		if (cmd.hasOption(SOURCEPATH_ARG))
		{
			sourcePath = new File(cmd.getOptionValue(SOURCEPATH_ARG));
		}
		map.put(BsjCompilerLocation.SOURCE_PATH, 
		        new RegularFileLocationManager(null, sourcePath));
		
		// set the generated sourcepath for BSJ files
		if (cmd.hasOption(GEN_SOURCEPATH_ARG))
		{
		    bsjSourcePath = new File(cmd.getOptionValue(GEN_SOURCEPATH_ARG));
		}
		map.put(BsjCompilerLocation.GENERATED_SOURCE_PATH, 
		        new RegularFileLocationManager(null, bsjSourcePath));
		
		// set the destination directory for finished class files
		if (cmd.hasOption(DESTINATION_ARG))
		{
			classOutput = new File(cmd.getOptionValue(DESTINATION_ARG));
		}
		map.put(BsjCompilerLocation.CLASS_OUTPUT, 
		        new RegularFileLocationManager(null, classOutput));
		
		// set the metaprogram classpath
		// the metaprogram will always have a classpath equal to what the 
		// user specifies unioned with the classpath of the running JVM
		if (cmd.hasOption(META_CLASSPATH_ARG))
		{
			metaProgramClasspath = metaProgramClasspath 
			        + File.pathSeparator 
			        + cmd.getOptionValue(META_CLASSPATH_ARG);
		}
		map.put(BsjCompilerLocation.METAPROGRAM_CLASSPATH, 
				new UnionLocationManager(null, metaProgramClasspath));		
		
		// set the object program classpath
		if (cmd.hasOption(OBJECT_CLASSPATH_ARG))
		{
			objectProgramClasspath = cmd.getOptionValue(OBJECT_CLASSPATH_ARG);
		}
		map.put(BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH, 
				new UnionLocationManager(null, objectProgramClasspath));
		
		//TODO
		map.put(BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH, 
		        new UnionLocationManager(null, System.getProperty("sun.boot.class.path")));
		
		//TODO
		map.put(BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH, 
		        new UnionLocationManager(null, System.getProperty("sun.boot.class.path")));
		
		// set up annotation processor stuff
		if (cmd.hasOption(ANNOTATION_PROCESSOR_PATH_ARG))
		{
		    annotationProcessorPath = cmd.getOptionValue(ANNOTATION_PROCESSOR_PATH_ARG);
		}
		map.put(BsjCompilerLocation.ANNOTATION_PROCESSOR_PATH, 
		        new UnionLocationManager(null, annotationProcessorPath));
		// TODO: is there a way in javac to control the annotation processor's output?
		map.put(BsjCompilerLocation.ANNOTATION_PROCESSOR_OUTPUT,
				map.get(BsjCompilerLocation.CLASS_OUTPUT));
		
		// create file manager from registry service
		BsjFileManagerFactory factory = BsjServiceRegistry.newFileManagerFactory();
		factory.setLocationManagerMappingsByManager(map);
		
		// create a new file manager from the options selected
		return factory.newFileManager();
	}

	/**
	 * Creates the set of valid Options for the bsjc.
	 * @return the set of valid Options.
	 */
	public static Options initOptions()
	{
		Options options = new Options();
		
		// options with arguments:
        Option objectClasspath = new Option(OBJECT_CLASSPATH_ARG, true, 
                "Specify where to find user class files");
        objectClasspath.setArgName("path");
        options.addOption(objectClasspath);
        
        Option metaClasspath = new Option(META_CLASSPATH_ARG, true, 
                "Specify where to find metaprogram class files");
        metaClasspath.setArgName("path");
        options.addOption(metaClasspath);
        
        Option annotationProcessorClasspath = new Option(ANNOTATION_PROCESSOR_PATH_ARG, true,
        		"Specify where to find annotation processors");
        annotationProcessorClasspath.setArgName("path");
        options.addOption(annotationProcessorClasspath);
        
        Option destination = new Option(DESTINATION_ARG, true, 
                "Specify where to place generated class files");
        destination.setArgName("directory");
        options.addOption(destination);
		
        Option sourcepath = new Option(SOURCEPATH_ARG, true,
                "Specify the source code path to search for class or interface definitions");
        sourcepath.setArgName("path");
        options.addOption(sourcepath);
		
        Option genSourcepath = new Option(GEN_SOURCEPATH_ARG, true,
                "Specify where to place BSJ generated files");
        genSourcepath.setArgName("path");
        options.addOption(genSourcepath);
		
        // options without arguments:
        options.addOption(VERSION_ARG, false, "Version information");        
		options.addOption(DEBUG_ARG, false, "Turns on debug logging");		
		options.addOption(TRACE_ARG, false, "Turns on trace logging");		
		options.addOption(HELP_ARG, false, "Print a synopsis of standard options");
		
		return options;
	}

	/**
	 * Compiles object files after parameters have been set.
	 * @throws IOException if an I/O error occurs.
	 */
	public void compile() throws IOException
	{
		BsjToolkitFactory toolkitFactory = BsjServiceRegistry.newToolkitFactory();
		toolkitFactory.setFileManager(bsjFileManager);
		BsjToolkit toolkit = toolkitFactory.newToolkit();
		
		BsjCompiler compiler = toolkit.getCompiler();
		compiler.compile(compileObjects, listener);
	}

	/**
	 * @return the bsjFileManager
	 */
	public BsjFileManager getBsjFileManager()
	{
		return bsjFileManager;
	}

	/**
	 * @param bsjFileManager the bsjFileManager to set
	 */
	public void setBsjFileManager(BsjFileManager bsjFileManager)
	{
		this.bsjFileManager = bsjFileManager;
	}

	public DiagnosticListener<BsjSourceLocation> getListener()
	{
		return listener;
	}

	public void setListener(DiagnosticListener<BsjSourceLocation> listener)
	{
		this.listener = listener;
	}

	/**
	 * @return the compileObjects
	 */
	public List<BsjFileObject> getCompileObjects()
	{
		return compileObjects;
	}

	/**
	 * @param compileObjects the compileObjects to set
	 */
	public void setCompileObjects(List<BsjFileObject> compileObjects)
	{
		this.compileObjects = compileObjects;
	}	
}
