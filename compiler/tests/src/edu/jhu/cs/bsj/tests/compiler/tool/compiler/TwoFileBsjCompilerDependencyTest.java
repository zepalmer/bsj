package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import org.junit.Assert;
import org.junit.Test;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;

public class TwoFileBsjCompilerDependencyTest extends AbstractBsjCompilerTest
{
	@Test
	public void testTwoFileDependencies() throws Exception
	{
	    BsjFileManager fileManager = performTest("TwoFileBsjCompilerDependencyTest");
	    ClassLoader loader = fileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT).getClassLoader();
	    DynamicClass aClass = new DynamicClass(loader, "A");
	    DynamicObject bObj = aClass.call("inst");
	    DynamicObject str = bObj.call("toString");
	    Assert.assertEquals("B", str.unwrap());
	}
}
