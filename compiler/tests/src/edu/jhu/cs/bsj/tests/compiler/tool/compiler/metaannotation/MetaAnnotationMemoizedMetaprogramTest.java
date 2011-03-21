package edu.jhu.cs.bsj.tests.compiler.tool.compiler.metaannotation;

import junit.framework.Assert;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

/**
 * Tests some sources that make use of meta-annotation memoization metaprograms.
 * @author Joseph Riley
 */
public class MetaAnnotationMemoizedMetaprogramTest extends AbstractBsjCompilerTest
{
	@Test
	public void testMemoization() throws Exception
	{
	    BsjFileManager fileManager = performTest("Memoized");
	    ClassLoader loader = fileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT).getClassLoader();
	    DynamicClass memoizedClass = new DynamicClass(loader, "MemoizedClass");
	    DynamicObject obj = memoizedClass.newInstance();
	    
	    Integer i = (Integer)obj.call("foo",2000,3000).unwrap();
	    Assert.assertTrue(i == (Integer)obj.call("foo",2000,3000).unwrap());
	    String s = (String)obj.call("bar", "test").unwrap();
	    Assert.assertTrue(s == (String)obj.call("bar", "test").unwrap());
	}
}
