package edu.jhu.cs.bsj.compiler.impl.tool.bsjc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;

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
	public BsjFileManager bsjFileManager;
	
	/**
	 * Diagnostic listener for compilation.
	 */
	private DiagnosticListener<? super JavaFileObject> listener;
	
	/**
	 * Objects to be compiled.
	 */
	public List<BsjFileObject> compileObjects;
	
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
		


		BsjFileObject bfo = null;
		try
		{
			bfo = bfm.getJavaFileForInput(
					BsjCompilerLocation.SOURCE_PATH, "BsjClass", Kind.SOURCE);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BsjC bsjc = new BsjC();
		bsjc.bsjFileManager = bfm;
		bsjc.compileObjects = Arrays.asList(bfo);
		bsjc.compile();
	}

	public void compile() throws IOException
	{
		StandardBsjCompiler compiler = new StandardBsjCompiler(bsjFileManager);
		compiler.compile(compileObjects, listener);
	}
	
}
