package edu.jhu.cs.bsj.compiler.impl.tool.bsjc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import edu.jhu.cs.bsj.compiler.impl.tool.compiler.StandardBsjCompiler;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationMappedFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.RegularFileLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.UnionLocationManager;
import edu.jhu.cs.bsj.compiler.impl.utils.diagnostic.DiagnosticPrintingListener;

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
	 * The {@link BsjFileManager} used for the filesystem abstraction.
	 */
	private BsjFileManager bsjFileManager;
	
	/**
	 * Diagnostic listener for compilation.
	 */
	private DiagnosticListener<? super JavaFileObject> listener;
	
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
		listener = new DiagnosticPrintingListener<JavaFileObject>(System.err);
	}
	
	/**
	 * Perform compilation in the manner of javac's command-line usage.
	 * @param args command-line arguments for compilation.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		// parse the command line arguments
		CommandLineParser parser = new PosixParser();
		CommandLine cmd = null;
		try
		{
			cmd = parser.parse(BsjC.initOptions(), args);
		} catch (ParseException e)
		{
			System.out.println("Invalid command line arguments: " + e.getMessage());
			System.exit(1);
		}
		
		// display version info and exit if requested
		if (cmd.hasOption("version"))
		{
			System.out.println("bsjc " + VERSION);
			System.exit(0);
		}
		
		// map the locations for the file manager
		Map<BsjCompilerLocation, LocationManager> map = new HashMap<BsjCompilerLocation, LocationManager>();
		
		// set the default values for the locations
		File sourcePath = new File(".");
		File classOutput = new File(".");
		File bsjSourcePath = new File("." + File.separator + "bsjgensrc");
		
		// apply the command line options that are present
		if (cmd.hasOption("sourcepath"))
		{
			sourcePath = new File(cmd.getOptionValue("sourcepath"));
		}
		map.put(BsjCompilerLocation.SOURCE_PATH, new RegularFileLocationManager(null, sourcePath));
		
		if (cmd.hasOption("gsp"))
		{
			sourcePath = new File(cmd.getOptionValue("gsp"));
		}
		map.put(BsjCompilerLocation.GENERATED_SOURCE_PATH, new RegularFileLocationManager(null, bsjSourcePath));
		
		if (cmd.hasOption("d"))
		{
			classOutput = new File(cmd.getOptionValue("d"));
		}
		map.put(BsjCompilerLocation.CLASS_OUTPUT, new RegularFileLocationManager(null, classOutput));
		
		//TODO
		map.put(BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("sun.boot.class.path")));
		map.put(BsjCompilerLocation.METAPROGRAM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("java.class.path")));
		
		//TODO
		map.put(BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("sun.boot.class.path")));
		map.put(BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("java.class.path")));
		
		// create a new file manager from the options selected
		BsjFileManager bfm = new LocationMappedFileManager(map);
		
		// get files for compilation
		//TODO extract the source files from the command line
		List<BsjFileObject> sourceFiles = new ArrayList<BsjFileObject>();		
		for (String sourceFile : args)
		{
			sourceFiles.add(
					bfm.getJavaFileForInput(
							BsjCompilerLocation.SOURCE_PATH, 
							sourceFile.replaceFirst(".java", ""), 
							Kind.SOURCE));
		}
		
		// compile the source files using the file manager
		BsjC bsjc = new BsjC();
		bsjc.setBsjFileManager(bfm);
		bsjc.setCompileObjects(sourceFiles);
		bsjc.compile();
	}
	
	/**
	 * Creates the set of valid Options for the bsjc.
	 * @return the set of valid Options.
	 */
	public static Options initOptions()
	{
		Options options = new Options();
		
		options.addOption("cp", "classpath", true, 
				"Specify where to find user class files and annotation processors");
		
		options.addOption("d", true, "Specify where to place generated class files");
		
		options.addOption("sourcepath", true, "Specify where to place generated class files");
		
		options.addOption("version", false, "Version information");
		
		options.addOption("gsp", "gensourcepath", true, 
			"Specify where to place BSJ generated files");
		
		return options;
	}

	public void compile() throws IOException
	{
		StandardBsjCompiler compiler = new StandardBsjCompiler(bsjFileManager);
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

	/**
	 * @return the listener
	 */
	public DiagnosticListener<? super JavaFileObject> getListener()
	{
		return listener;
	}

	/**
	 * @param listener the listener to set
	 */
	public void setListener(DiagnosticListener<? super JavaFileObject> listener)
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
