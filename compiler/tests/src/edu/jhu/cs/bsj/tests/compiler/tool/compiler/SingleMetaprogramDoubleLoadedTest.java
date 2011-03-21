package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import org.junit.Assert;
import org.junit.Test;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;

/**
 * Tests whether or not a single metaprogram being loaded twice by two different metaprograms is handled properly.
 * @author Zachary Palmer
 */
public class SingleMetaprogramDoubleLoadedTest extends AbstractBsjCompilerTest
{
	@Test
	public void testMetaprogramDoubleLoading() throws Exception
	{
	    BsjFileManager fileManager = performTest("SingleMetaprogramDoubleLoaded", "Main");
	    ClassLoader loader = fileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT).getClassLoader();
	    DynamicClass mainClass = new DynamicClass(loader, "Main");
	    Assert.assertEquals(0, mainClass.call("foo").unwrap());
	}
}
