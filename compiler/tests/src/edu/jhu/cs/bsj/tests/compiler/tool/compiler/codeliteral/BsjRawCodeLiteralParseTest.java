package edu.jhu.cs.bsj.tests.compiler.tool.compiler.codeliteral;

import org.junit.Assert;
import org.junit.Test;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

public class BsjRawCodeLiteralParseTest extends AbstractBsjCompilerTest
{
	@Test
	public void testRawCodeLiteralParsing() throws Exception
	{
	    BsjFileManager fileManager = performTest("RawCodeLiteral");
	    ClassLoader loader = fileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT).getClassLoader();
	    DynamicClass rawCodeLiteralClass = new DynamicClass(loader, "RawCodeLiteralClass");
	    DynamicObject obj = rawCodeLiteralClass.call("foo");
	    Assert.assertEquals("hello!", obj.unwrap());
	}
}
