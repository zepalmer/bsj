package edu.jhu.cs.bsj.tests.compiler.tool.compiler.metaannotation;

import org.junit.Assert;
import org.junit.Test;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

/**
 * Tests some sources that make use of meta-annotation singleton metaprograms.
 * @author Joseph Riley
 * @author Zachary Palmer
 */
public class MetaAnnotationSingletonMetaprogramTest extends AbstractBsjCompilerTest
{
	@Test
	public void testBsjCompiler() throws Exception
	{
	    BsjFileManager fileManager = performTest("Singleton");
	    ClassLoader loader = fileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT).getClassLoader();
	    DynamicClass singletonClass = new DynamicClass(loader, "SingletonClass");
	    DynamicObject obj1 = singletonClass.call("getInstance");
	    DynamicObject obj2 = singletonClass.call("getInstance");
	    Assert.assertEquals(obj1.unwrap(), obj2.unwrap());
	    obj1.call("setX", 7);
	    Assert.assertEquals(7, obj2.call("getX").unwrap());
	}
}
