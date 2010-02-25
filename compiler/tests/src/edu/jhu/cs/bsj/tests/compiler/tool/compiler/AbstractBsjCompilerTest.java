package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.impl.tool.compiler.StandardBsjCompiler;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationMappedFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.RegularFileLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.UnionLocationManager;
import edu.jhu.cs.bsj.tests.AbstractTest;

public abstract class AbstractBsjCompilerTest extends AbstractTest
{
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

	/**
	 * Performs a BSJ compilation operation test.  This method compiles and runs a BSJ program.
	 * 
	 * @param sourcePath The root directory containing the sources.
	 * @param paths The paths of the source files to compile.  The first file is assumed to be the main class.
	 * @throws Exception If anything goes wrong.
	 */
	protected void performTest(File sourcePath, String... paths) throws Exception
	{
		log4jConfigure("trace", "edu.jhu.cs.bsj.compiler.impl.tool.filemanager/debug",
				"edu.jhu.cs.bsj.compiler.tool.parser.antlr/debug");

		Map<BsjCompilerLocation, LocationManager> map = new HashMap<BsjCompilerLocation, LocationManager>();

		File test = new File("." + File.separator + "local");
		test.mkdir();

		map.put(BsjCompilerLocation.SOURCE_PATH, new RegularFileLocationManager(null, sourcePath));
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

		BsjFileManager bfm = new LocationMappedFileManager(map);

		List<BsjFileObject> files = new ArrayList<BsjFileObject>();
		for (String path : paths)
		{
			String packageString;
			String filename;
			if (path.indexOf('/') != -1)
			{
				packageString = path.substring(0, path.lastIndexOf('/')).replaceAll("/", ".");
				filename = path.substring(path.lastIndexOf('/')+1);
			} else
			{
				packageString = "";
				filename = path;
			}
			filename = filename + ".bsj";
			BsjFileObject bfo = bfm.getFileForInput(BsjCompilerLocation.SOURCE_PATH, packageString, filename);
			files.add(bfo);
		}

		StandardBsjCompiler compiler = new StandardBsjCompiler(bfm);
		compiler.compile(files, null);

		Object o = bfm.getClassLoader(BsjCompilerLocation.CLASS_OUTPUT).loadClass(paths[0].replaceAll("/",".")).newInstance();
		Method mainMethod = o.getClass().getMethod("main", String[].class);
		mainMethod.invoke(null, new Object[]{new String[0]});
	}
}
