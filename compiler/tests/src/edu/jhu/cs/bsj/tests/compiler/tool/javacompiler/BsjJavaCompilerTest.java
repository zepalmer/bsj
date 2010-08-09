package edu.jhu.cs.bsj.tests.compiler.tool.javacompiler;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager.Location;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import junit.framework.Assert;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.InMemoryLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationMappedFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.RegularFileLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.UnionLocationManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.tool.filemanager.LocationManager;
import edu.jhu.cs.bsj.tests.AbstractTest;

public class BsjJavaCompilerTest extends AbstractTest
{
	@Test
	public void testJavaCompilerWithBsjFileManager() throws Exception
	{
		log4jConfigure("trace");

		JavaCompiler jc = ToolProvider.getSystemJavaCompiler();

		Map<StandardLocation, LocationManager> map = new HashMap<StandardLocation, LocationManager>();
		File test = new File("." + File.separator + "local");
		test.mkdir();
		map.put(StandardLocation.SOURCE_PATH, new RegularFileLocationManager(null, test));
		map.put(StandardLocation.SOURCE_OUTPUT, new RegularFileLocationManager(null, test));
		map.put(StandardLocation.PLATFORM_CLASS_PATH, new UnionLocationManager(null,
				System.getProperty("sun.boot.class.path")));
		map.put(StandardLocation.CLASS_PATH, new UnionLocationManager(null, System.getProperty("java.class.path")));
		map.put(StandardLocation.CLASS_OUTPUT, new RegularFileLocationManager(null, test));
		map.put(StandardLocation.ANNOTATION_PROCESSOR_PATH, new RegularFileLocationManager(null, test));
		BsjFileManager bfm = new LocationMappedFileManager(map);

		String codeStr = "public class JoeClass {" + "public String toString(){"
				+ "SmallClass sc = new SmallClass(); return(\"Hello Joe!\");" + "}" + "}";
		String codeStr2 = "public class SmallClass {" + "public String toString(){" + "return(\"SmallClass!\");" + "}"
				+ "}";

		List<Location> locations = new ArrayList<Location>();
		locations.add(StandardLocation.CLASS_OUTPUT);
		locations.add(StandardLocation.SOURCE_PATH);

		BsjFileObject bfo = bfm.getJavaFileForOutput(StandardLocation.SOURCE_PATH, "SmallClass", Kind.SOURCE, null);
		bfo.setCharContent(codeStr2);

		BsjFileObject bfo2 = bfm.getJavaFileForOutput(StandardLocation.SOURCE_PATH, "JoeClass", Kind.SOURCE, null);
		bfo2.setCharContent(codeStr);

		System.out.println(bfo.getName());
		System.out.println(bfo2.getName());
		System.out.println(bfo.inferBinaryName());

		List<JavaFileObject> fileObjects = Arrays.<JavaFileObject> asList(bfo, bfo2);

		// The next step is to compile Iterable collection of java files and close file manager:

		if (!(jc.getTask(null, bfm, null, null, null, fileObjects).call()))
		{
			Assert.fail("Compilation failure.");
		}
		bfm.close();

		Object o = bfm.getClassLoader(StandardLocation.CLASS_OUTPUT).loadClass("JoeClass").newInstance();
		Assert.assertEquals("Hello Joe!", o.toString());
	}
	
	@Test
	public void testJavaCompilerWithInMemoryLocationManager() throws Exception
	{
		log4jConfigure("trace");

		JavaCompiler jc = ToolProvider.getSystemJavaCompiler();

		Map<StandardLocation, LocationManager> map = new HashMap<StandardLocation, LocationManager>();
		map.put(StandardLocation.SOURCE_PATH, new InMemoryLocationManager(null));
		map.put(StandardLocation.SOURCE_OUTPUT, new InMemoryLocationManager(null));
		map.put(StandardLocation.PLATFORM_CLASS_PATH, new UnionLocationManager(null,
				System.getProperty("sun.boot.class.path")));
		map.put(StandardLocation.CLASS_PATH, new UnionLocationManager(null, 
				System.getProperty("java.class.path")));
		map.put(StandardLocation.CLASS_OUTPUT, new InMemoryLocationManager(null));
		map.put(StandardLocation.ANNOTATION_PROCESSOR_PATH, new InMemoryLocationManager(null));
		BsjFileManager bfm = new LocationMappedFileManager(map);

		String codeStr = "public class JoeClass {" + "public String toString(){"
				+ "SmallClass sc = new SmallClass(); return(\"Hello Joe!\");" + "}" + "}";
		String codeStr2 = "public class SmallClass {" + "public String toString(){" + "return(\"SmallClass!\");" + "}"
				+ "}";

		BsjFileObject bfo = bfm.getJavaFileForOutput(StandardLocation.SOURCE_PATH, "SmallClass", Kind.SOURCE, null);
		bfo.setCharContent(codeStr2);

		BsjFileObject bfo2 = bfm.getJavaFileForOutput(StandardLocation.SOURCE_PATH, "JoeClass", Kind.SOURCE, null);
		bfo2.setCharContent(codeStr);

		System.out.println(bfo.getName());
		System.out.println(bfo2.getName());
		System.out.println(bfo.inferBinaryName());

		List<JavaFileObject> fileObjects = Arrays.<JavaFileObject> asList(bfo, bfo2);

		// The next step is to compile Iterable collection of java files and close file manager:

		if (!(jc.getTask(null, bfm, null, null, null, fileObjects).call()))
		{
			Assert.fail("Compilation failure.");
		}
		bfm.close();

		Object o = bfm.getClassLoader(StandardLocation.CLASS_OUTPUT).loadClass("JoeClass").newInstance();
		Assert.assertEquals("Hello Joe!", o.toString());
	}
}
