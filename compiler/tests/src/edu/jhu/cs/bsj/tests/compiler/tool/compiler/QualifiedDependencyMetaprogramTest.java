package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import org.junit.Assert;
import org.junit.Test;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;

public class QualifiedDependencyMetaprogramTest extends AbstractBsjCompilerTest
{
	@Test
	public void testQualifiedDependency() throws Exception
	{
	    BsjFileManager fileManager = performTest("QualifiedDependency");
	    ClassLoader loader = fileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT).getClassLoader();
	    DynamicClass mainClass = new DynamicClass(loader, "A");
	    Assert.assertEquals(5, mainClass.field("X").unwrap());
	}
}
