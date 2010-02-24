package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.impl.tool.compiler.StandardBsjCompiler;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationMappedFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.RegularFileLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.UnionLocationManager;
import edu.jhu.cs.bsj.tests.AbstractTest;

public class BsjCompilerTest extends AbstractTest
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

	@Test
	public void testBsjCompiler() throws Exception
	{
		log4jConfigure("trace", "edu.jhu.cs.bsj.compiler.impl.tool.filemanager/debug",
				"edu.jhu.cs.bsj.compiler.tool.parser.antlr/debug");

		Map<BsjCompilerLocation, LocationManager> map = new HashMap<BsjCompilerLocation, LocationManager>();

		File test = new File("." + File.separator + "local");
		test.mkdir();

		map.put(BsjCompilerLocation.SOURCE_PATH, new RegularFileLocationManager(null, new File(
				EXAMPLES + File.separator + "individual-files" + File.separator + "hand-written")));
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

		BsjFileObject bfo = bfm.getFileForInput(BsjCompilerLocation.SOURCE_PATH, "", "BsjClass.bsj");

		StandardBsjCompiler compiler = new StandardBsjCompiler(bfm);
		compiler.compile(Arrays.asList(bfo), null);

		Object o = bfm.getClassLoader(BsjCompilerLocation.CLASS_OUTPUT).loadClass("BsjClass").newInstance();
		System.out.println(o);
	}

}
