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

import com.sun.corba.se.spi.ior.MakeImmutable;

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
		CommandLineParser parser = new PosixParser();
		CommandLine cmd = null;
		try
		{
			cmd = parser.parse(BsjC.initOptions(), args);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		

		
		
		
		
		// TODO Auto-generated method stub
		Map<BsjCompilerLocation, LocationManager> map = new HashMap<BsjCompilerLocation, LocationManager>();
		map.put(BsjCompilerLocation.SOURCE_PATH, new RegularFileLocationManager(null, new File(".")));//src
		map.put(BsjCompilerLocation.GENERATED_SOURCE_PATH, new RegularFileLocationManager(null, new File(".\\gensrc")));//gensrc
		map.put(BsjCompilerLocation.CLASS_OUTPUT, new RegularFileLocationManager(null, new File(".")));//bin
		
		map.put(BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("sun.boot.class.path")));
		map.put(BsjCompilerLocation.METAPROGRAM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("java.class.path")));
		
		map.put(BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("sun.boot.class.path")));
		map.put(BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("java.class.path")));
		
		BsjFileManager bfm = new LocationMappedFileManager(map);

		// handle paths
		
		// get files for compilation
		List<BsjFileObject> sourceFiles = new ArrayList<BsjFileObject>();		
		for (String sourceFile : args)
		{
			sourceFiles.add(
					bfm.getJavaFileForInput(
							BsjCompilerLocation.SOURCE_PATH, 
							sourceFile.replaceFirst(".java", ""), 
							Kind.SOURCE));
		}
		
		
		// compile
		BsjC bsjc = new BsjC();
		bsjc.setBsjFileManager(bfm);
		bsjc.setCompileObjects(sourceFiles);
		bsjc.compile();
	}

	public void compile() throws IOException
	{
		StandardBsjCompiler compiler = new StandardBsjCompiler(bsjFileManager);
		compiler.compile(compileObjects, listener);
	}
	
	public static Options initOptions()
	{
		Options options = new Options();
		
		options.addOption("cp", "classpath", true, 
				"Specify where to find user class files and annotation processors");
		options.addOption("d", true, "Specify where to place generated class files");
		options.addOption("version", false, "Version information");
		options.addOption("gsp", "gensourcepath", true, 
			"Specify where to place BSJ generated files");
		
		return options;
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
