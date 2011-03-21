package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import org.junit.Assert;
import org.junit.Test;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;

public class PackageNodeLoadTest extends AbstractBsjCompilerTest
{
	@Test
	public void testBsjCompiler() throws Exception
	{
	    BsjFileManager fileManager = performTest("PackageLoadTest", "Main");
	    ClassLoader loader = fileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT).getClassLoader();
	    DynamicClass mainClass = new DynamicClass(loader, "Main");
	    Assert.assertEquals(0, mainClass.call("foo").unwrap());
	}
}
